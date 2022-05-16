import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    private UserDAO userDAO = mock(UserDAO.class);
    private User user = mock(User.class);
    private SecurityService securityService = mock(SecurityService.class);

    @Test
    public void tesVerificationUpdateUser() throws Exception{
        userDAO.updateUser(user);
        verify(userDAO).updateUser(user);
    }

    @Test
    public void tesVerificationAssignPassword() throws Exception{
        UserServiceImpl usr = new UserServiceImpl(userDAO,securityService);
        usr.assignPassword(user);
        verify(user).getPassword();
    }
}
