import { HttpRequest, HttpInterceptorFn, HttpHandlerFn } from "@angular/common/http";

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<unknown>, next: HttpHandlerFn) => {
  console.log('AuthInterceptor: Intercepting request', req);
  var token = ''
  if (typeof window !== "undefined") {
    token = localStorage.getItem('currentUser') ? JSON.parse(localStorage.getItem('currentUser')!).token : '';
  }
  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${token}`
    }
  });
  return next(authReq);
};