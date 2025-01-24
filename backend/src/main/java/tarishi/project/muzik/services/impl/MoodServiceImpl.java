package tarishi.project.muzik.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import tarishi.project.muzik.model.Mood;
import tarishi.project.muzik.repository.MoodRepository;
import tarishi.project.muzik.services.MoodService;

@Service
public class MoodServiceImpl implements MoodService {

	private final MoodRepository moodRepository;

	public MoodServiceImpl(MoodRepository moodRepository) {
		this.moodRepository = moodRepository;
	}

	@Override
	public List<UUID> getAllMoodIds(UUID emotionId) {
		List<Mood> moodsList = moodRepository.findMoodsByEmotion(emotionId);
		List<UUID> moodIdList = new ArrayList<UUID>();

		for (Mood mood : moodsList) {
			moodIdList.add(mood.getId());
		}

		return moodIdList;
	}
}
