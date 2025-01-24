package tarishi.project.muzik.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import tarishi.project.muzik.model.Genre;
import tarishi.project.muzik.repository.GenreRepository;
import tarishi.project.muzik.services.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	private final GenreRepository genreRepository;

	public GenreServiceImpl(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	@Override
	public List<String> getAllGenre(List<UUID> moodIdList) {
		List<String> genreList = new ArrayList<>();

		for (UUID moodId : moodIdList) {
			List<Genre> genres = genreRepository.findGenresByMood(moodId);

			// get the genre name and add it to list
			for (Genre genre : genres) {
				genreList.add(genre.getGenre());
			}
		}

		return genreList;
	}
}
