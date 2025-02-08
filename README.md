# 🎧 MUZIK 

## Mood-Based *Music* recomendation app

Muzik is your go-to buddy for finding the perfect tunes to match your vibe! Feeling chill, happy, or maybe a bit nostalgic? Let Muzik take care of the playlist while you enjoy the moment. 🎶

https://github.com/user-attachments/assets/87ae3eb2-2aa1-4ea1-aabf-b915d67e8061

## 🚀 Purpose

MUZIK helps you find the perfect music for whatever you're feeling. We often know our mood but have trouble finding songs that match it. With Muzik, you simply share how you're feeling, and the app uses emotion detection to create a playlist tailored to your mood. Whether you're looking for something chill, upbeat, or reflective, muzik curates the ideal soundtrack for the moment, enhancing your experience with every track.
This project gives you both a creative exploration and a technical demonstration, focusing on API integrations, sentiment analysis, and scalable system design.

## 🛠️ Tech-Stack

- **Frontend:** ReactJS for a modern and dynamic user interface.
- **Backend:** Java Spring Boot to handle business logic and APIs.
- **Database:** Supabase (PostgreSQL) for secure and scalable data management.
- **APIs:**
   * Hugging Face: Emotion detection and sentiment analysis.
   * Spotify API: Song search and playlist generation.
- **Testing:** JUnit and Mockito for robust unit testing of backend services.

## 📚 Lessons Learned

- API Integration Challenges: Managing OAuth flows, session tokens and ensuring secure Spotify API access provided valuable insights into third-party API    integration.
- Data Mapping: Designing relationships between emotions, moods, and genres highlighted the importance of organized backend logic.
- User Design: Creating an intuitive and engaging interface made me realize the value of combining functionality with user experience.
- Testing and Debugging: Writing comprehensive tests for API-driven functionality enhanced code reliability and reduced debugging time significantly.
- Live Production Environment: Deployed back-end using Docker, Azure Redis for Cache, and Microsoft Azure Container Apps. Front-end on Muzik with GitHub Actions for CI/CD.


## ⏭️ Next Steps

- Deploy the app online. (done)
- Go through beta testing with 10-15 users. (in-progress)
- Implement app enhancements and refactoring. (in-progress)
