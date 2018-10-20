import { Component, OnInit } from '@angular/core';
import { TasksService } from '../../service/tasks.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Tasks } from '../../model/tasks';

@Component({
  selector: 'app-add-tasks',
  templateUrl: './add-tasks.component.html',
  styleUrls: ['./add-tasks.component.css']
})
export class AddTasksComponent implements OnInit {

  tasks:Tasks;
  isUpdate:Boolean;
  constructor(private taskservice:TasksService,private activatedroute:ActivatedRoute,private router:Router)
   {

   }

  ngOnInit()
   {
      this.tasks=new Tasks();
      this.isUpdate=false;
      this.activatedroute.params.subscribe
      (
          params=>
          {
            let tid=params['id'];
            if(tid)
            {
              this.taskservice.getById(tid).subscribe
              (
                data=>
                {
                  this.tasks=data;
                  this.isUpdate=true;
                }
              )
            }
          }
      )
   }


   save()
   {
     if(this.isUpdate)
     {
       this.taskservice.updateTask(this.tasks).subscribe
       (
         data=>
         {
           this.router.navigateByUrl("/?opt=a&id="+data.id);
         },
         error=>
         {
           alert("some error occured");
         }
       )
     }
     else
     {
       this.taskservice.addTask(this.tasks).subscribe
       (
         data=>
         {
           this.router.navigateByUrl("/?opt=a&id="+data.id);
         },
         error=>
         {
           alert("some error occured");
         }
       );
     }
   }

}
