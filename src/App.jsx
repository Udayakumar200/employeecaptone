import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EmployeeComponent from './components/EmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';

function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<ListEmployeeComponent />} />
          <Route path="/employees" element={<ListEmployeeComponent />} />
          <Route path="/add-employee" element={<EmployeeComponent />} />
          <Route path="/edit-employee/:id" element={<EmployeeComponent />} />
          <Route path="/view-employee/:id" element={<ViewEmployeeComponent />} />

        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
