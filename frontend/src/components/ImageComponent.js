import React from 'react';
import musikArt from '../assets/muzik-art.png'; // Import the image

const ImageComponent = ({ customStyle }) => {
    return (
        <img
            src={musikArt}
            alt="Music Art"
            className="img-fluid" // Bootstrap class for responsiveness
            style={{
                ...customStyle, // Merge parent styles with default styles
                borderRadius: '15px',
                boxShadow: '0 4px 12px rgba(0, 0, 0, 0.1)',
                transition: 'transform 0.3s ease',
            }}
            onMouseEnter={(e) => e.target.style.transform = 'scale(1.05)'}
            onMouseLeave={(e) => e.target.style.transform = 'scale(1)'}
        />
    );
}

export default ImageComponent;
