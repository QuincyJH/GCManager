package com.global.gcmanager.service.test;

import com.global.gcmanager.dao.GameDAO;
import com.global.gcmanager.service.GCMService;
import com.global.gcmanager.service.GCMServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.util.

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GCMServiceTest {

    @Mock
    private GameDAO gameDAO;
    @InjectMocks
    private GCMService gcmService = new GCMServiceImpl();
    //@Rule
    //public ExpectedException expectedException = ExpectedException.none();

}
