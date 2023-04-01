function ReportDetails(props) {
    return (
        <div>
            <h3 className='raportul2'>Report {props.report.reportId}</h3>
            <p >image: {props.report.imageBase64}</p>
            <p>category: {props.report.category}</p>
            <p>comments: {props.report.comments}</p>
            {/* <p>contacts: {props.imageBase64}</p> */}
            <p>latitude: {props.report.geoTagging.latitude}</p>
            <p>longitude: {props.report.geoTagging.longitude}</p>
            <p>Date created: {props.report.timestamp}</p>
        </div>
    )
}

export default ReportDetails;