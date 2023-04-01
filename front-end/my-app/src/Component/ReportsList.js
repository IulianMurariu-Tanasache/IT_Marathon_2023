import ReportDetails from './ReportDetails';

function ReportsList({ reports }) {

    const handleSubmit = (report) => {
        console.log('we do this report ' + report.reportId);
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