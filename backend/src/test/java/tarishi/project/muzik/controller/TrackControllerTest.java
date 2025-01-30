package tarishi.project.muzik.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import tarishi.project.muzik.model.EmotionType;
import tarishi.project.muzik.model.ErrorResponse;
import tarishi.project.muzik.model.Track;
import tarishi.project.muzik.services.impl.*;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrackControllerTest {}