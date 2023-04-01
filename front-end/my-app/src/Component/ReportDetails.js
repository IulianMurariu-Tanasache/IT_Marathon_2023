function ReportDetails(props) {
    return (
        <div className="span-indent">
            <h3 className='final2'>Report {props.report._id}</h3>
            {/* <p>image: {props.report.imageBase64}</p> */}
            <img id="ItemPreview" src={"data:image/jpeg;base64," + props.report.imageBase64}  width="355" height="200"></img>
            <p>category: {props.report.category}</p>
            <p>comments: {props.report.comments}</p>
            <p>contacts: </p>
            <div className="span-indent">
                {props.report.contacts !== null &&
                <span>
                    <p>first name: {props.report.contacts.firstName}</p>
                    <p>last name: {props.report.contacts.lastName}</p>
                    <p>email: {props.report.contacts.email}</p>
                    <p>phone number: {props.report.contacts.tel}</p>
                </span>
                }
            </div>
            <p>latitude: {props.report.geoTagging.latitude}</p>
            <p>longitude: {props.report.geoTagging.longitude}</p>
            <p>Date created: {props.report.timestamp}</p>
        </div>
    )
}

export default ReportDetails;