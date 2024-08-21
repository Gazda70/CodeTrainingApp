export interface Question {
    questionId:number,
    text:string,
    answers:Array<Answer>,
    chosenAnswer:Answer
}

export interface Answer {
    answerId:number,
    text:string
}

export interface CardContent {
    title: string,
    description: string,
    imageUrl: string,
    routerLink: string
}