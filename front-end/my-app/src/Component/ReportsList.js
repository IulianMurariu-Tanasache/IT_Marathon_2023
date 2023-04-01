import ReportDetails from './ReportDetails';
import {useNavigate} from 'react-router-dom'

function ReportsList({ reports }) {

    let Navigates = useNavigate();

    const handleSubmit = (report) => {
        console.log('we do this report ' + report.reportId);
        Navigates("/issue", {state : report})
    }

  console.log(reports);
  return(
    <div>
      <div>
        <ul>
          {reports.map((report) => (
            <div>
            <ReportDetails report={report} />
            <button onClick={() => {handleSubmit(report)}}>Take report</button>
           </div>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default ReportsList;