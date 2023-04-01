function ReportDetails(props) {
    return (
        <div>
            <h3>Report {props.report.reportId}</h3>
            <p>image: {props.report.imageBase64}</p>
            <p>category: {props.report.category}</p>
            <p>comments: {props.report.comments}</p>
            {/* <p>contacts: {props.imageBase64}</p> */}
            <p>geoTagging: {props.report.geoTagging}</p>
            <p>Date created: {props.report.timestamp}</p>
        </div>
    )
}

export default ReportDetails;