package vn.edu.nlu.service2;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity2.BaseUser;

import java.util.List;

@Service
public interface ISendmailService {
    public boolean sendmail(String toEmail, String subject, String msg);

    public boolean sendVerificationEmail(BaseUser user, String verify);

    boolean sendmailResetpassword(BaseUser user, String s);
}
