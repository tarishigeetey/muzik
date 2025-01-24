import { Routes, Route } from 'react-router-dom';
import TopNavbar from './components/TopNavbar';
import Footer from './components/Footer';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import ResultsPage from './pages/ResultsPage';
import About from './pages/About';

function App() {
  return (
    <div className="App d-flex flex-column min-vh-100">
      <TopNavbar />
      {/* Ensure content takes up the available space */}
      <div className="flex-grow-1">
        <Routes>
          <Route path="/" element={<LoginPage />} />
          <Route path="/home" element={<HomePage />} />
          <Route path="/result" element={<ResultsPage />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
}

export default App;
