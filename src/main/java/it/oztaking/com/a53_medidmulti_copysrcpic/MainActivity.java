package it.oztaking.com.a53_medidmulti_copysrcpic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);

        //2.将tomcat.png转换为bitmap然后显示到iv_src
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.tomcat);
        iv_src.setImageBitmap(bitmap);

        //3.拷贝原图
        //创建模板
        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //创建画布
        Canvas canvas = new Canvas(copyBitmap);
        //创建画笔
        Paint paint = new Paint();
        //作画
        canvas.drawBitmap(bitmap,new Matrix(),paint);

        for (int i=0; i<100; i++){
            copyBitmap.setPixel(20+i,30, Color.BLACK);
        }
        //将画出的内容显示到ImageView中
        iv_copy.setImageBitmap(copyBitmap);

    }
}
