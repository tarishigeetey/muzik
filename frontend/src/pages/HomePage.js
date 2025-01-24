import Container from 'react-bootstrap/Container';
import MoodInput from '../components/MoodInput';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import recordImage from '../assets/record.png';  // Import the image from src/assets

function HomePage() {
    const [user, setUser] = useState({ userId: null, displayName: null });
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchUserDetails() {
            const response = await fetch(`${process.env.REACT_APP_BACKEND_URL}/api/user-details`, {
                method: "GET",
                credentials: "include",
            });
            if (response.ok) { // authorized user
                const data = await response.json();
                setUser({ userId: data.userId, displayName: data.displayName });
            } else if (response.status === 401) { // unauthorized access
                navigate("/"); // go back to login page
            }
        }
        fetchUserDetails();
    }, [navigate]); // Added dependency array for better useEffect behavior

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
            transition: { delay: 0.2, duration: 1 },
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
        <Container className="custom-container">
            <motion.div
                initial="hidden"
                animate="visible"
                variants={containerVariants}
                className="text-center"
            >
                {/* Add the rotating image */}
                <motion.img
                    src={recordImage}  // Using the imported image
                    alt="Record"
                    className="rotating-image mb-0"  // Adding the rotating class
                    style={{ width: '100px', height: 'auto', marginBottom: '-20px' }}
                    variants={h1Variants}
                />

                <motion.h1 variants={h1Variants}>
                    hello, <span id="userName">{user.displayName}</span>
                </motion.h1>

                <motion.h5 variants={h5Variants}>
                    what’s your vibe today?
                </motion.h5>

                <MoodInput />
            </motion.div>
        </Container>
    );
}

export default HomePage;
