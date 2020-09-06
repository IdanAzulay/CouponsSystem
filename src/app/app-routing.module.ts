import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AdminComponent } from './components/admin/admin/admin.component';
import { CreateUserComponent } from './components/admin/create-user/create-user.component';
import { InActiveUserComponent } from './components/admin/in-active-user/in-active-user.component';
import { ActiveUserComponent } from './components/admin/active-user/active-user.component';
import { GetAllUsersComponent } from './components/admin/get-all-users/get-all-users.component';
import { CreateClientComponent } from './components/admin/create-client/create-client.component';
import { RemoveClientComponent } from './components/admin/remove-client/remove-client.component';
import { GetAllClientsComponent } from './components/admin/get-all-clients/get-all-clients.component';
import { GetCodeComponent } from './components/user/get-code/get-code.component';
import { UserComponent } from './components/user/user/user.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "home", component: HomeComponent},

  { path: "admin", component: AdminComponent, children:
  [{ path: "createUser" , component: CreateUserComponent},
   { path: "inActiveUser", component: InActiveUserComponent},
   { path: "activeUser", component: ActiveUserComponent},
   { path: "getAllUsers", component: GetAllUsersComponent},
   { path: "createClient", component: CreateClientComponent},
   { path: "removeClient", component: RemoveClientComponent},
   { path: "getAllClients", component: GetAllClientsComponent}]
  },

  { path : "user", component: UserComponent, children:
  [{ path: "getCode", component: GetCodeComponent},


]}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
