import React from 'react';
import { motion } from 'framer-motion';
import Spinner from 'react-bootstrap/Spinner';

const Loading = () => {
    const messages = [
        "Your vibe just changed the algorithm.",
        "Stay tuned, we're manifesting results.",
        "Lowkey processing... highkey worth the wait.",
        "Turning your input into digital gold.",
        "This request? Pure serotonin on its way.",
        "We're making moves—your input's about to pop off.",
    ];

    const loadingVariants = {
        hidden: { opacity: 0, y: 50 },
        visible: {
            opacity: 1,
            y: 0,
            transition: { delay: 1, duration: 1, ease: 'easeOut' },
        },
    };

    return (
        <motion.div
            initial="hidden"
            animate="visible"
            variants={loadingVariants}
            className="d-flex justify-content-center align-items-center py-3"
        >
            <Spinner animation="border" variant="light" size="sm" role="status">
                <span className="visually-hidden">Loading...</span>
            </Spinner>
            <p className="mt-3 ms-1 text-light">
                {messages[Math.floor(Math.random() * messages.length)]}
            </p>
        </motion.div>
    );
};

export default Loading;
