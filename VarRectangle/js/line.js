/**
 * Created by wangyan on 14-6-18.
 */
window.tool = window.tool || {};

(function (tool) {

    var LineType={
        /**
         * 横线
         */
        X:0,

        /**
         * 竖线
         */
        Y:1
    };

    function Line(x1, y1, x2, y2) {
        this._x1 = x1;
        this._y1 = y1;
        this._x2 = x2;
        this._y2 = y2;
        this.lineWidth=1.5;
        this.strokeStyle='rgba(255,0,0,0.5)';
        this._type={};
        this._actionScope={};
        this._init();
    }


    Line.prototype._init=function(){
        if(this._x1==this._x2){
            this._type=LineType.Y;
            this._actionScope={
                x:this._x1+4,
                y:this._y1,
                width:3,
                height:Math.abs(this._y1-this._y2)
            };
        }else if(this._y1==this._y2){
            this._type=LineType.X;
            this._actionScope={
                x:this._x1,
                y:this._y1+4,
                width:Math.abs(this._x1-this._x2),
                height:3
            };
        }else{
            throw '不支持斜线，仅支持横线或者竖线';
        }
    }

    Line.prototype.drawCtx=function(ctx){
        ctx.lineWidth = this.lineWidth;
        ctx.strokeStyle = this.strokeStyle;
        ctx.moveTo(this._x1,this._y1);
        ctx.lineTo(this._x2,this._y2);
    }

    Line.prototype.draw=function(canvas){
        var ctx=canvas.getContext("2d");
        ctx.beginPath();
        ctx.moveTo(this._x1,this._y1);
        ctx.lineTo(this._x2,this._y2);
        ctx.closePath();
        ctx.lineWidth = this.lineWidth;
        ctx.strokeStyle = this.strokeStyle;
        ctx.stroke();
    }

    Line.prototype.isAction=function(x,y){
        if(x>=this._actionScope.x&&x<=this._actionScope.x+this._actionScope.width*2){
            if(y>=this._actionScope.y&&y<=this._actionScope.y+this._actionScope.height){
                return true;
            }
        }
        return false;
    }

    Line.prototype.move=function(x,y,preX,preY,canvas){
        if(this._x1==preX&&this._y1==preY){
            this._x1=x;
            this._y1=y;
        }else if(this._x2==preX&&this._y2==preY){
            this._x2=x;
            this._y2=y;
        }else{
            throw '没有找到该线的移动端点。';
        }
        var ctx=canvas.getContext("2d");

        ctx.clearRect(this._actionScope.x,this._actionScope.y,this._actionScope.width,this._actionScope.height);
        //this._init();
       // this.draw(canvas);
    }

    tool.Line=Line;

})(window.tool);
