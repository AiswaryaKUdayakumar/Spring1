import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Interview } from '../interview';
import { InterviewService } from '../interview.service';

@Component({
  selector: 'app-interview',
  templateUrl: './interview-form.component.html',
  styleUrls: ['./interview-form.component.css']
})
export class InterviewFormComponent implements OnInit {

  interviewForm!: FormGroup;
  interview: Interview = new Interview();
  submitted = false;

  constructor(private formBuilder: FormBuilder, private interviewService: InterviewService) { }

  ngOnInit(): void {
    this.interviewForm = this.formBuilder.group({
      name: ['', Validators.required],
      emailId: ['', Validators.required],
      phNumber: ['', Validators.required],
      skills: ['', Validators.required],
      experience: ['', Validators.required],
      date: ['', Validators.required],
      time: ['', Validators.required],
      link: ['', Validators.required],
      poc: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.interviewForm.invalid) {
      return;
    }
    this.interviewService.createInterview(this.interview)
      .subscribe(data => console.log(data), error => console.log(error));
    this.interview = new Interview();
  }

}
