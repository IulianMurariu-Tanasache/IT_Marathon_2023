function ReportDetails(props) {
    return (
        <div>
            <h3>Report {props.report._id}</h3>
            {/* <p>image: {props.report.imageBase64}</p> */}
            <img id="ItemPreview" src={"data:image/jpeg;base64," + props.report.imageBase64}  width="200" height="200"></img>
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