
var uploadWidget = cloudinary.createUploadWidget({
    cloudName: 'dvopkjbyv',
    uploadPreset: 'button_upload',
}, (error, result) => {
    if(!error && result && result.event === "success"){
        console.log('Done!', result.info);
    }
})

document.getElementById("imageID").addEventListener("click", () => {
    uploadWidget.open();
}, false)