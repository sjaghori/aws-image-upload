import React, {
  userState,
  userEffect,
  useEffect,
  useState,
  useCallback,
} from "react";
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";
import Dropzone, { useDropzone } from "react-dropzone";

const UserProfiles = () => {
  const [UserProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get(`http://localhost:8080/api/v1/user-profile`).then((res) => {
      console.log(res);
      setUserProfiles(res.data);
    });
  };

  useEffect(() => {
    fetchUserProfiles();
  }, []);
  return UserProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        {userProfile.userProfileId ? (
          <img 
            src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`}
            alt="profilePicture"
          />
        ) : null}
        {/* todo: profile image */}
        <br />
        <br />
        <h1>{userProfile.username}</h1>
        <p>{userProfile.userProfileId}</p>
        <UserDropzone {...userProfile} />
        <br />
      </div>
    );
  });
};

function UserDropzone({ userProfileId }) {
  const onDrop = useCallback((acceptedFiles) => {
    // do something with the file
    const file = acceptedFiles[0];
    console.log(file);

    const formData = new FormData();
    formData.append("file", file);

    axios
      .post(
        `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      )
      .then(() => {
        console.log("file uploaded successfully");
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop });

  return (
    <div {...getRootProps({ className: "dropzone" })}>
      <input {...getInputProps()} />
      <input {...getInputProps()} />
      <span>{isDragActive ? "📂" : "📁"}</span>
      <p>Drop the files here ...</p>
      <p>Drag 'n' drop profile image, or click to select profile image</p>
    </div>
  );
}

function App() {
  return (
    <div className="App">
      <UserProfiles></UserProfiles>
    </div>
  );
}

export default App;
