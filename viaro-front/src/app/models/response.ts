export class ResponseDTO<T> {
    success!: boolean;
    message!: string;
    data!: T;
}