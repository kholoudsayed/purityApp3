package com.example.kholoud.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import com.squareup.picasso.Picasso;

/**
 * Created by kholoud on 10/17/2019.
 */

public class SliderAdapter  extends PagerAdapter{
    Context context;
    LayoutInflater layoutInflater;
    public  SliderAdapter(Context context)
    {
        this.context=context;
    }

    //Arrays ---------------
    public  int[] Slid_Images={
            R.drawable.a1,
            R.drawable.cleaningservice,
            R.drawable.garbage,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13 ,
            R.drawable.a14,
            R.drawable.a15,
            R.drawable.a16,
            R.drawable.a17,
            R.drawable.a18,
            R.drawable.a19,
            R.drawable.a20,
            R.drawable.a21


   };

public String [] Heading_Names={

        "Use a wet rubber glove to remove pet hair",
        "Use a coffee filter to clean glass or mirrors easily",
        "Use tights to stop your vacuum cleaner hoovering up coins",
        " Reuse cleaning sponges – just microwave them clean",
        "Use an old toothbrush for cleaning your bathroom" ,
        "Get felt tip pen stains out of wood with toothpaste",
        " Unblock a clogged drain for free with baking soda" ,
        "Clean your chopping board with lemon" ,
        "stop rust on garden furniture with tomato sauce",
        "Use ketchup to shine your copper pans",
        "Stop squeaky floorboards with baby powder",
        "Use bicarbonate of soda to clean your dishwasher",
        "Clean your toilet stains with Coke",
        "Sharpen your scissors with tin foil" ,
        "Seal an envelope with nail varnish" ,
        "Polish furniture with olive oil",
        "Clean your bath with a grapefruit",
"Remove water marks and cup rings from tables with a hairdryer",
        "Remove rust from cutlery with an onion" ,
        "Use toothpaste to defog mirrors" ,
        "Cleaning tip from Aggie Mackenzie",
        "Get rid of the dirty ring around a shirt collar with shampoo",
" Clean your remote"





};
    public String [] Desc={

"If Fido and Felix have fluffed up your house and are making you sneeze, there's a cheap and easy solution. A damp washing up glove can easily be dragged over soft furnishings like sofas and curtains (and even trouser legs!) to remove animal fur.",
            "Use a coffee filter to clean glass or mirrors easily Ah coffee - you're the thing that gets us out of bed, and now we've discovered you offer so much more. Smarten up grubby windows without any chemicals – just give them a sweep with a clean coffee filter. It works like magic." ,
            "Don't throw away those laddered tights! Save money and precious small objects by using the foot of a pair of tights over your hoover nozzle. It will catch any change, hair bands and other bits and bobs before they get sucked away. " ,
            "It can feel like you're constantly buying new packs of kitchen and bathroom cleaning sponges, and not only do the costs add up, but it's not great for the environment to keep throwing dirty ones away. Get more use from your cleaning sponges by giving them a quick one or two-minute blast in the microwave on a high setting. This will kill off bacteria.",
"Don’t throw away your old toothbrush – it can be a really useful tool. Give it a rinse in boiling water to get rid of any germs, and use it to get into nooks and crannys that your vacuum cleaner can't reach. It’s especially handy in the bathroom, for cleaning hard to reach areas around the tap or drain.\n" ,
"If the grandchildren have gone crazy with the marker pens on your bannisters, table or anything else made from wood, rub it gently with a little bit of toothpaste to lift off the stain. Then go and give them a good telling off and a nice (easy to erase) set of pencils instead!\n" ,

"Bicarbonate of soda to the rescue yet again! This time it's a marvel for unblocking hair or food-clogged drains. Pour one part baking soda, followed by one part vinegar down it, then cover with a wet cloth as the two react with one another to clean the drain naturally. Wait five minutes and then run some hot water to clear it. \n" ,

"Our chopping boards get a lot of use, from joints of meat and fillets of fish, to cutting up fruit and vegetables most evenings - so it's no wonder they end up looking a bit tired. Lemons are great for lifting stains from chopping boards, as well as removing any smells. Still not shifting? Sprinkle with baking soda and repeat.\n" ,
            "If your patio furniture has rusted too, dab on some ketchup before rubbing away with a cloth – the rust will lift right off. Then use the rest of the bottle on a delicious summer barbecue! \n",

"Copper is having a moment in fashion right now, and copper pans are a gorgeous way to modernise your kitchen. If they get dirty after use, there's a cheap solution hiding in your cupboard. Humble tomato sauce is actually great for cleaning, and will make copper pans shine after a quick rub.  \n",
"If you keep waking up your hubby by stepping on creaky floorboards in the night, he'll thank you for trying out this easy trick. Use talcum powder or baby powder to silence noisy wooden floors. Drop some onto the floor and sweep into the cracks, wiping away the excess.\n" ,
"Keeping your dishwasher in good working order will safe you lots of money in the long-term, and it's easy to do. For starters, shake baking soda onto a damp sponge and wipe it around the edges of your dishwasher to remove any food residue.\n" ,
"And that's not all that this humble soft drink can offer in terms of cleaning. Get a grubby loo back to sparkling white by pouring in a can of cola. Let it sit in the bowl overnight, give it a quick scrub with a brush and then flush the next morning for a great effect.\n",
"Scissors get blunt so easily, especially if you use them to cut paper or wrap presents. But you don't need to replace them. Just use your scissors to cut up a piece of aluminium foil to sharpen them in an instant. \n" ,
"If you’ve got a duff envelope that just won’t seal, or you want to reseal a letter that’s been opened, use a blob of nail varnish to stick it back down. Opt for clear nail polish if you don't want it to look strange! We also like to use clear nail varnish to stop ladders spreading in our tights, so it's worth investing in a bottle to keep in the house.\n",
            "As well as having great health benefits, olive oil can be handy around the home. Put a few drops onto a duster and use it to polish your wooden furniture – so much nicer than chemical polish, and it won't cause any strong smells.\n" ,
            "Get rid of water marks or stains in your bathtub by cutting a grapefruit in half, sprinkling on some rock salt and giving it a good scrub. Have the other half for a nutritious breakfast!\n" ,

"If someone hasn’t used a coaster and has marked your coffee table, use a hairdryer on it before wiping the area with a tiny amount of olive oil. Hey-presto - good as new.\n" ,
"There's no need to cry over rusty cutlery - unless cutting an onion makes you weep. If your knives and forks have rusted, stick their ends into an onion a couple of times and the rust should lift straight off.\n" ,
"If you get annoyed when, after a hot bath or shower, you can''t see yourself in a misty mirror, toothpaste could be the answer! Just rub your bathroom mirror with toothpaste and wipe clean with a clean, dry cloth before you shower and hey-presto - one easy to use mist-free mirror.\n" ,
"How Clean Is Your House star Aggie Mackenzie stresses the importance of keeping your iron in tip-top shape. To remove any excess limescale on an older iron (which will block the steam holes) heat the iron, then unplug it and leave to cool down. Fill the reservoir with a solution of one part clear vinegar to one partwater, leave for an hour or so, then empty and rinse out a few times with clean water. \n" ,
   "It's easy for sweat, oil and general grime to stick to a shirt collar and ruin your otherwise smartest outfits. If it refuses to budge int he washing machine, don't get rid of it! Just gently rub some of your normal shampoo around it, give it a little scrub and then pop it back into the washing machine.\n",
"If you’re worried about your remote-control collecting dirt and bacteria from daily use, try cleaning it with a small amount of hand sanitizer and a paper towel. For extra effectiveness, use an cotton bud to get those hard-to-reach bits between the buttons!\n"


    };






    @Override
    public int getCount() {
        return  Heading_Names.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view==(RelativeLayout)object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView  slidImageView =(ImageView) view.findViewById(R.id.Image_Slid);
        TextView slidheaderView =(TextView) view.findViewById(R.id.Slide_header);
        TextView  sliddescView =(TextView) view.findViewById(R.id.Description);


        slidImageView.setImageResource(Slid_Images[position]);

        slidheaderView.setText(Heading_Names[position]);
        sliddescView.setText(Desc[position]);

        container.addView(view);
        Picasso.get()
                .load(Slid_Images[position])
                .transform(new CircleTransform())
                .into(slidImageView);

        return  view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }






}


class CircleTransform implements Transformation {

    boolean mCircleSeparator = false;

    public CircleTransform() {
    }

    public CircleTransform(boolean circleSeparator) {
        mCircleSeparator = circleSeparator;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }
        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());
        Canvas canvas = new Canvas(bitmap);
        BitmapShader shader = new BitmapShader(squaredBitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.FILTER_BITMAP_FLAG);
        paint.setShader(shader);
        float r = size / 2f;
        canvas.drawCircle(r, r, r - 1, paint);
        // Make the thin border:
        Paint paintBorder = new Paint();
        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setColor(Color.argb(84,0,0,0));
        paintBorder.setAntiAlias(true);
        paintBorder.setStrokeWidth(1);
        canvas.drawCircle(r, r, r-1, paintBorder);

        // Optional separator for stacking:
        if (mCircleSeparator) {
            Paint paintBorderSeparator = new Paint();
            paintBorderSeparator.setStyle(Paint.Style.STROKE);
            paintBorderSeparator.setColor(Color.parseColor("#ffffff"));
            paintBorderSeparator.setAntiAlias(true);
            paintBorderSeparator.setStrokeWidth(4);
            canvas.drawCircle(r, r, r+1, paintBorderSeparator);
        }
        squaredBitmap.recycle();
        return bitmap;
    }


    @Override
    public String key() {
        return "circle";
    }
}




