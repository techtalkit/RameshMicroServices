import axios from 'axios';

const EMPLOYEE_SERVICE_BASE_URL="http://localhost:8383/api/employees";

const EMPLOYEE_ID=2;

class EmployeeService{
    getEmployee(){
        axios.get(EMPLOYEE_SERVICE_BASE_URL+"/"+EMPLOYEE_ID);
    }
}
export default new EmployeeService
