package org.example.Test;

import org.example.dao.JobsDAO;
import org.example.models.Jobs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

@ExtendWith(MockitoExtension.class)
public class TestJobDao {

    @InjectMocks
    JobsDAO dao;

    @Test
    void testUpdateJob() throws SQLException, ClassNotFoundException {

        Jobs J = new Jobs(19,"Test",4000,10000);

        Assertions.assertDoesNotThrow(()-> dao.updateJob(J));

        Jobs newJ = dao.selectJob(J.getJob_id());

        Assertions.assertNotNull(newJ);
        Assertions.assertEquals(newJ.getJob_id(),J.getJob_id());
        Assertions.assertEquals(newJ.getJob_title(),J.getJob_title());
    }
}












