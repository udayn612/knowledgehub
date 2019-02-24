import { Component, OnInit } from '@angular/core';
import { UploadFile, UploadEvent, FileSystemFileEntry } from 'ngx-file-drop';
import { Observable } from 'rxjs';
import { UploadService } from '../service/upload.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {


  public files: UploadFile[] = [];
  currentFileUpload: File;
  showFile = false;
  fileUploads:Observable<string[]>;
  msg: string = null;

  constructor(private uploadService: UploadService) { }
 
  ngOnInit() {
  }
 
  selectFile(event:UploadEvent) {
    this.files = event.files;
    console.log(event);
  
  for (const droppedFile of event.files) {

    // Is it a file?
    if (droppedFile.fileEntry.isFile) {
      const fileEntry = droppedFile.fileEntry as FileSystemFileEntry;
      fileEntry.file((file: File) => {
    

    
    this.uploadService.pushFileToStorage(file)
      .subscribe( File => {
        this.msg = 'successfully uploaded';
      },
      error => {
        this.msg='failed to upload file';
      });
    })}
  }

}
  
  public fileOver(event){
    console.log(event);
  }

  public fileLeave(event){
    console.log(event);
  }
}
