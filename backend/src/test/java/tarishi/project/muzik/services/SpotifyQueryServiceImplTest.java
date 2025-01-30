package tarishi.project.muzik.services;

import jakarta.servlet.http.HttpSession;
import tarishi.project.muzik.model.Track;
import tarishi.project.muzik.services.impl.SpotifyQueryServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpotifyQueryServiceImplTest {
	
}