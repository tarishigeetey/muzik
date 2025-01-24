import React from 'react';
import musikArt from '../assets/muzik-art.png'; // Import the image

const ImageComponent = () => {
    return (
        <img
            src={musikArt}
            alt="Music Art"
            className="img-fluid me-4"  // Bootstrap class for responsiveness
            style={{
                maxWidth: '100%',  // Ensure image never overflows
                height: 'auto',    // Maintain aspect ratio
                borderRadius: '15px',
                boxShadow: '0 4px 12px rgba(0, 0, 0, 0.1)',
                transition: 'transform 0.3s ease',
                width: '100%',    // Ensure it scales according to the parent container
                maxWidth: '400px', // Set a maximum width for larger screens
            }}
            onMouseEnter={(e) => e.target.style.transform = 'scale(1.05)'}
            onMouseLeave={(e) => e.target.style.transform = 'scale(1)'}
        />
    );
}

export default ImageComponent;
