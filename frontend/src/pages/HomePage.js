import Container from 'react-bootstrap/Container';
import MoodInput from '../components/MoodInput';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { motion } from "framer-motion";

function HomePage() {
    const [userName, setUserName] = useState(null);
    const navigate = useNavigate();
    let userId;

    // First time log in contains userId 
    const queryParams = new URLSearchParams(window.location.search);
    if (queryParams.get('userId') != null) {
        // Get spotify userId from query parameters
        userId = queryParams.get('userId');
        localStorage.setItem('spotifyUser', userId);
    }

    if (localStorage.getItem('spotifyUser') != null) {
        userId = localStorage.getItem('spotifyUser');
    }

    useEffect(() => {
        async function fetchUserDetails() {
            try {
                const response = await fetch(`${process.env.REACT_APP_BACKEND_URL}/api/user-details?userId=${encodeURIComponent(userId)}`, {
                    method: "GET",
                    credentials: "include",
                });

                if (response.ok) {
                    const data = await response.json();
                    setUserName(data.displayName);
                } else if (response.status === 401) {
                    localStorage.clear();
                    console.error("Unauthorized access.");
                    navigate("/?error=Unauthorized"); // Redirect to login page
                }
            } catch (error) {
                console.error("Error fetching user details:", error);
            }
        }
        fetchUserDetails();
    }, [navigate]);

    // Animation variants for the container
    const containerVariants = {
        hidden: { opacity: 0, y: -50 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { duration: 0.8, ease: "easeOut" },
        },
    };

    // Animation variants for the text
    const h1Variants = {
        hidden: { opacity: 0, y: 20 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { delay: 0.5, duration: 1 },
        },
    };

    const h5Variants = {
        hidden: { opacity: 0, y: 20 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { delay: 1.6, duration: 1 },
        },
    };

    return (
        <Container>
            <motion.div
                initial="hidden"
                animate="visible"
                variants={containerVariants}
            >
                <motion.h1 variants={h1Variants}>
                    Hey <span id="userId">{userName}</span>
                </motion.h1>

                <motion.h5 variants={h5Variants}>
                    Let's turn your mood into music.
                </motion.h5>

                <MoodInput userId={userId} />
            </motion.div>
        </Container>
    );
}

export default HomePage;