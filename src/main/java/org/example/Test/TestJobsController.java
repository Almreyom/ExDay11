package org.example.Test;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.example.controller.JobsController;
import org.example.dao.JobsDAO;
import org.example.models.Jobs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class  TestJobsController {
    @InjectMocks
    JobsController jobController;
    @Mock
    UriInfo uriInfo;
    @Mock
    JobsDAO dao;

    @Test
    public void TestUpdate() {
        Jobs jobs = new Jobs(6, "It", 4000, 11000);
        URI uri = URI.create("http://localhost/api/job/1");

        when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromUri(uri));

        Assertions.assertDoesNotThrow(()-> jobController.UPDATE_JOB(1,jobs));
    }
}