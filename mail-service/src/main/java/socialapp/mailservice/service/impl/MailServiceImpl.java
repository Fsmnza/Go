package socialapp.mailservice.service.impl;

import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import socialapp.mailservice.model.dto.EmailMessageDto;
import socialapp.mailservice.model.enums.MailMessageType;
import socialapp.mailservice.service.MailService;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;
    private final Configuration ftl;

    @Value("${spring.mail.sender.email}")
    private String sender;

    @Override
    public void send(
            EmailMessageDto message,
            MailMessageType type
    ) {
        var msg = mailSender.createMimeMessage();

        try {
            var helper = new MimeMessageHelper(
                    msg,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            var template = ftl.getTemplate(type.getTemplate());

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, Map.of(
                    "content", message.message(),
                    "subject" , type.getSubject()
            ));

            helper.setText(html, true);
            helper.setTo(message.email());
            helper.setFrom(sender);
            helper.setSubject(type.getSubject());

            mailSender.send(msg);

            log.info("Mail Sent Successfully {}", message);
        } catch (Exception e) {
            log.error("Error while Sending Mail, msg {}", e.getMessage());
        }
    }
}
