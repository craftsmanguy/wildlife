export class FileNode {
    children: FileNode[];
    filename: string;
    type: any;
};

export class FileFlatNode {
    constructor(
        public expandable: boolean, public filename: string, public level: number, public type: any) { }
};



