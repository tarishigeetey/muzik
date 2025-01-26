import { useSearchParams } from "react-router-dom";
import { Link } from "react-router-dom";
import LoginButton from "../components/LoginButton";
import { Alert } from "react-bootstrap";
import ImageComponent from "../components/ImageComponent"; // Import ImageComponent

function LoginPage() {
    const [queryParams] = useSearchParams();
    const errorMsg = queryParams.get("error");

    return (
        <div className="container d-flex flex-column align-items-center mb-1"> {/* Reduced margin bottom */}
            <div className="row align-items-center justify-content-center text-center my-2"> {/* Reduced vertical spacing */}
                {/* Image Section */}
                <div className="col-md-6 d-flex justify-content-center mb-3 mb-md-0"> {/* Adjusted margin bottom on small screens */}
                    <Link to="/about"> {/* Link wrapping the image */}
                        <ImageComponent customStyle={{ width: '400px', maxWidth: '100%', height: 'auto' }} /> {/* Reasonable size */}
                    </Link>
                </div>
                {/* Text and Button Section */}
                <div className="col-md-6 d-flex flex-column justify-content-center">
                    {errorMsg && ErrorAlert(errorMsg)}
                    <h1 className="pb-3 text-center" style={{ textAlign: "justify" }}>
                        find your vibe, your song with <em>muzik</em>.
                    </h1>
                    <div className="d-flex justify-content-center w-100">
                        <LoginButton />
                    </div>
                </div>
            </div>
        </div>
    );
}

function ErrorAlert(errorMsg) {
    return (
        <Alert variant="danger" key="loginError" dismissible={true}>
            <Alert.Heading>Yikes! We hit a snag.</Alert.Heading>
            <p>{errorMsg}. Please try login again.</p>
        </Alert>
    );
}

export default LoginPage;
