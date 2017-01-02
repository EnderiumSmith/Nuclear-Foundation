package NuclearFoundation.rendering;

import javax.vecmath.Point3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.AxisDirection;

public class ModelUtil {
	public static final VertexFormat FORMAT_BLOCK_NORMAL;

	static {
		/* Forge doesn't use default values for a normal if the block model doesn't provide it, so this is a format that
		 * has both light and a normal */
		FORMAT_BLOCK_NORMAL = new VertexFormat(DefaultVertexFormats.BLOCK);
		FORMAT_BLOCK_NORMAL.addElement(DefaultVertexFormats.NORMAL_3B);
		FORMAT_BLOCK_NORMAL.addElement(DefaultVertexFormats.PADDING_1B);
	}

	/**
	 * A method for calculating the points of a face for an axis-aligned cuboid, with a given center and radius.
	 */
	public static Point3f[] getPointsForFace(EnumFacing face, Tuple3f center, Tuple3f radius) {
		Point3f centerOfFace = new Point3f(center);
		Point3f faceAdd = new Point3f(face.getFrontOffsetX() * radius.x, face.getFrontOffsetY() * radius.y, face.getFrontOffsetZ() * radius.z);
		centerOfFace.add(faceAdd);
		Vector3f faceRadius = new Vector3f(radius);
		if (face.getAxisDirection() == AxisDirection.POSITIVE) {
			faceRadius.sub(faceAdd);
		} else {
			faceRadius.add(faceAdd);
		}
		return getPoints(centerOfFace, faceRadius);
	}

	/**
	 * Inner method for {@link #getPointsForFace(EnumFacing, Tuple3f, Tuple3f)} that requires centerFace and faceRadius to be specific for the face.
	 */
	public static Point3f[] getPoints(Point3f centerFace, Tuple3f faceRadius) {
		Point3f[] array = { new Point3f(centerFace), new Point3f(centerFace), new Point3f(centerFace), new Point3f(centerFace) };
		array[0].add(addOrNegate(faceRadius, false, false));
		array[1].add(addOrNegate(faceRadius, false, true));
		array[2].add(addOrNegate(faceRadius, true, true));
		array[3].add(addOrNegate(faceRadius, true, false));
		return array;
	}

	/**
	 * Either adds 1 or subtracts 1 depending on which U or V co-ord this face is. These values must match what is used for the U and V texture co-ords.
	 */
	public static Vector3f addOrNegate(Tuple3f coord, boolean u, boolean v) {
		boolean zisv = coord.x != 0 && coord.y == 0;
		float x = coord.x * (u ? 1 : -1);
		float y = coord.y * (v ? -1 : 1);
		float z = coord.z * (zisv ? (v ? -1 : 1) : (u ? 1 : -1));
		Vector3f neg = new Vector3f(x, y, z);
		return neg;
	}

	/**
	 * This will turn a vertex normal into a packed int from, ready for the graphics card to accept.
	 */
	public static int normalToPackedInt(float x, float y, float z) {
		return normalAsByte(x, 0) //
			| normalAsByte(y, 8) //
			| normalAsByte(z, 16);
	}

	private static int normalAsByte(float norm, int offset) {
		return ((int) (norm * 0x7f)) << offset;
	}
}
