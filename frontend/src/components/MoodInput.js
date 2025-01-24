import Form from 'react-bootstrap/Form';
import { useEffect, useState } from 'react';
import { motion } from 'framer-motion';
import Loading from './Loading';

function MoodInput() {
    const [userMood, setUserMood] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    const handleChange = (e) => {
        e.preventDefault();
        setUserMood(e.target.value);
    };

    const handleError = (error) => {
        console.error('Error fetching tracks:', error);
        throw error;
    };

    async function handleSubmit(e) {
        e.preventDefault();

        console.log('Submitted mood:', userMood);

        const mood = encodeURIComponent(userMood.trim());

        if (mood.length === 0 || mood.length < 3) {
            alert('Please enter a valid mood');
            return;
        }

        // Show the loading spinner as soon as the submit is clicked
        setIsLoading(true);

        try {
            const response = await fetch(`${process.env.REACT_APP_BACKEND_URL}/api/get-tracks?submission=${mood}`, {
                method: 'GET',
                credentials: 'include',
            });

            const data = await response.json();

            if (response.ok) {
                // Redirect immediately after fetching data
                window.location.href = `/result?data=${encodeURIComponent(JSON.stringify(data))}`;
            } else {
                alert('Failed to fetch tracks. Please try again.');
            }
        } catch (error) {
            handleError(error);
        } finally {
            setIsLoading(false); // Hide the loading spinner after the fetch completes
        }
    }

    // Animation variants
    const formVariants = {
        hidden: { opacity: 0, y: 50 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { delay: 3, duration: 1, ease: 'easeOut' },
        },
    };

    const inputVariants = {
        hidden: { opacity: 0, y: 20 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { delay: 1.5, duration: 0.6 },
        },
    };

    const textVariants = {
        hidden: { opacity: 0 },
        visible: {
            opacity: 1,
            transition: { delay: 1.5, duration: 0.9 },
        },
    };

    return (
        <>
            {isLoading ? <Loading /> :
                <motion.div
                    initial="hidden"
                    animate="visible"
                    variants={formVariants}
                    className="d-flex justify-content-center align-items-center">
                    <Form onSubmit={handleSubmit}>
                        <Form.Group controlId="formUserMood">
                            <motion.label variants={textVariants}>
                                <Form.Label hidden>Describe how you feel</Form.Label>
                            </motion.label>
                            <motion.div variants={inputVariants}>
                                <Form.Control
                                    type="text"
                                    onChange={handleChange}
                                    value={userMood}
                                    autoComplete="off"
                                    placeholder='"I miss my home"'
                                    required
                                    className="form-control-lg"
                                />
                            </motion.div>
                        </Form.Group>
                    </Form>
                </motion.div>}
        </>
    );
}

export default MoodInput;
