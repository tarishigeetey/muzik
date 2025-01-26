import React from 'react';
import { motion } from 'framer-motion';
import devImage from '../assets/dev.png'; // Importing the dev.png image

const About = () => {

    // Animation variants
    const containerVariants = {
        hidden: { opacity: 0, y: -50 },
        visible: {
            opacity: 1, y: 0,
            transition: { duration: 1, ease: "easeOut" },
        },
    };

    const h1Variants = {
        hidden: { opacity: 0, y: 20 },
        visible: {
            opacity: 1, y: 0,
            transition: { delay: 0.2, duration: 1 },
        },
    };

    const pVariants = {
        hidden: { opacity: 0, y: 20 },
        visible: {
            opacity: 1, y: 0,
            transition: { delay: 1, duration: 1 },
        },
    };

    return (
        <motion.div
            className="container overflow-auto py-3 col-10"
            initial="hidden"
            animate="visible"
            variants={containerVariants}>
            <motion.h1 variants={h1Variants}>about MUZIK.</motion.h1>
            <motion.img 
                src={devImage} 
                alt="Developer working" 
                className="mt-4 rounded" 
                style={{ width: '250px', height: '250px' }} 
                initial={{ opacity: 0 }} 
                animate={{ opacity: 1 }} 
                transition={{ delay: 0.5, duration: 1 }}
            />
            <motion.div variants={pVariants} className="small">
                <p>When you're in the mood for music, you already know what you're feeling and what you need—whether it's a genre, artist, or vibe to match your mood. <br /><strong>Muzik</strong> connects those emotional dots, offering personalized song recommendations that perfectly align with your mood.</p> 
                <p>Built as a creative experiment and technical showcase, Muzik explores API integrations, scalable design, and unit testing. It’s where code meets creativity.</p> 
                <p>In Jan 2025, I set myself the challenge of creating an MVP in just 2-3 weeks—a timeframe that mimics a sprint. It was a journey of learning, from gathering requirements to building a web app without a step-by-step guide. Through research, peer advice, search through numerous websites for ideas and after lots of trial and error, I’m thrilled with the outcome!</p> 
                <p>I hope Muzik brings a fresh track to your playlist today! 🎶</p>
            </motion.div>
        </motion.div>
    );
}

export default About;
