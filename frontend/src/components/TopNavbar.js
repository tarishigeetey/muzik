import { NavLink } from 'react-router-dom';
import { Container, Nav, Navbar, Col } from 'react-bootstrap';

const TopNavbar = () => {
  return (
    <Navbar className="container mb-auto" expand="sm"> {/* Remove fixed-top */}
      <Container>
        <Col className="text-start col-9">
          <Navbar.Brand className="me-auto">
            <Nav.Link as={NavLink} to="/" className="text-yellow">
              <h3 id="brandName">muzik.</h3>
            </Nav.Link>
          </Navbar.Brand>
        </Col>

        <Navbar.Toggle aria-controls="top-navbar" id="navbarToggler" />
        <Navbar.Collapse id="top-navbar">
          <Nav>
            <Nav.Link as={NavLink} to="/home" className="mx-3 text-yellow">
              home
            </Nav.Link>
            <Nav.Link as={NavLink} to="/about" className="mx-3 text-yellow">
              about
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default TopNavbar;
