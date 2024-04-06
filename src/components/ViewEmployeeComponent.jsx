
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { viewEmployee } from '../services/employeeEservices';

const ViewEmployeeComponent = () => {
  const { id } = useParams();
  const [employee, setEmployee] = useState(null);

  useEffect(() => {
    console.log("Employee ID:", id); 
    if (id) {
      viewEmployee(id)
        .then((response) => {
          setEmployee(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  return (
    <div className='container'>
  <h2 className='text-center'>Employee Details</h2>
  {employee ? (
    <div className='card'>
      <div className='card-body'>
        <p className='card-text'><strong>First Name:</strong> {employee.firstName}</p>
        <p className='card-text'><strong>Last Name:</strong> {employee.lastName}</p>
        <p className='card-text'><strong>Email:</strong> {employee.email}</p>
      </div>
    </div>
  ) : (
    <p>Loading employee details...</p>
  )}
</div>

   
  );
};

export default ViewEmployeeComponent;
