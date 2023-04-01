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
      <div className='scrollDiv'>
        <ul>
          {reports.map((report) => (
            <div className='raportul'>
            <ReportDetails report={report} />
            <button className='corner3' onClick={() => {handleSubmit(report)}}> Take report</button>
           </div>
          ))}
        </ul>
      </div>
  );
}

export default ReportsList;