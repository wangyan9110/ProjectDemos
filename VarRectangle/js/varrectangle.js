/**
 * @author yywang5
 */
window.varRect=window.varRect||{};

(function(varRect){

    function Point(point){
        this.x=point.x;
        this.y=point.y;
    }

    Point.groupByX=function(points){
        var pointsGroup1=[];
        var pointsGroup2=[];
        var tempX=points[0].x;
        for(var index=0;index<points.length;index++){
            if(points[index].x==tempX){
                pointsGroup1.push(points[index]);
            }else{
                pointsGroup2.push(points[index]);
            }
        }
        return {g1:pointsGroup1,g2:pointsGroup2};
    }

    Point.groupByY=function(points){
        var pointsGroup1=[];
        var pointsGroup2=[];
        var tempY=points[0].y;
        for(var index=0;index<points.length;index++){
            if(points[index].y==tempY){
                pointsGroup1.push(points[index]);
            }else{
                pointsGroup2.push(points[index]);
            }
        }
        return {g1:pointsGroup1,g2:pointsGroup2};
    }

    function RectDes(rectDes){
        this.left=rectDes.left;
        this.top=rectDes.top;
        this.width=rectDes.width;
        this.height=rectDes.height;
    }

    RectDes.prototype.getPoints=function(){
        var points=[];
        points.push(new Point({x:this.left,y:this.top}));
        points.push(new Point({x:this.left,y:this.top+this.height}));
        points.push(new Point({x:this.left+this.width,y:this.top}));
        points.push(new Point({x:this.left+this.width,y:this.top+this.height}));
        return points;
    }

    function Line(canvas,point1,point2){
        this._canvas=canvas;
        this._point1=point1;
        this._point2=point2;
    }

    Line.prototype.draw=function(){
        var ctx=this._canvas.getContext('2d');
        ctx.beginPath();
        ctx.moveTo(this._point1.x,this._point1.y);
        ctx.lineTo(this._point2.x,this._point2.y);
        ctx.closePath();
        ctx.lineWidth=1.5;
        ctx.strokeStyle = 'rgba(255,0,0,0.5)';
        ctx.stroke();
    }

    Line.prototype.move=function(prePoint,newPoint){
        if(prePoint.x==this._point1.x&&prePoint.y==this._point1.y){
            this._point1=newPoint;
        }else{
            this._point2=newPoint;
        }
        var ctx=this._canvas.getContext('2d');
        if(this._point1.x==this._point2.x){
            ctx.clearRect(this._point1.x,this._point1.y,this._point2.x-this._point1.x,2);
        }else{
            ctx.clearRect(this._point1.x,this._point2)
        }
    }

    function Rect(rect){
        this._points=rect.getPoints();
        this._canvas=rect.canvas;
    }

    Rect.prototype.draw=function(){

    }


    function init(canvas){
        var ctx=canvas.getContext("2d");
        ctx.beginPath();
        ctx.moveTo(100,100);
        ctx.lineTo(200,100);
        ctx.lineTo(200,200);
        ctx.lineTo(100,200);
        ctx.lineTo(100,100);
        ctx.closePath();
        ctx.lineWidth = 1.5;
        ctx.strokeStyle = 'rgba(255,0,0,0.5)';
        ctx.stroke();
    }

    varRect.init=init;
})(window.varRect);