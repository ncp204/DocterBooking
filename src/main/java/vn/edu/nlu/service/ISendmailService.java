package vn.edu.nlu.service;

import org.springframework.stereotype.Service;
import vn.edu.nlu.entity.BaseUser;

@Service
public interface ISendmailService {
    public boolean sendmail(String toEmail, String subject, String msg);

    public boolean sendVerificationEmail(BaseUser user, String verify);

    boolean sendmailResetpassword(BaseUser user, String s);
}
