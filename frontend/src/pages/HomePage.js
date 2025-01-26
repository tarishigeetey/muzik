import Container from 'react-bootstrap/Container';
import MoodInput from '../components/MoodInput';
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { motion } from "framer-motion";

function HomePage() {
    const [user, setUser] = useState({ userId: null, displayName: null });
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchUserDetails() {
            const response = await fetch(`${process.env.REACT_APP_BACKEND_URL}/api/user-details`, {
                method: "GET",
                credentials: "include",
            });
            if (response.ok) {
                const data = await response.json();
                setUser({ userId: data.userId, displayName: data.displayName });
            } else if (response.status === 401) {
                navigate("/");
            }
        }
        fetchUserDetails();
    }, [navigate]);

    const containerVariants = {
        hidden: { opacity: 0, y: -50 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { duration: 0.8, ease: "easeOut" },
        },
    };

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