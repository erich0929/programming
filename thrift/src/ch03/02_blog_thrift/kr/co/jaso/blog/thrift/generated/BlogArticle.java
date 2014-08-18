/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package kr.co.jaso.blog.thrift.generated;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class BlogArticle implements TBase<BlogArticle, BlogArticle._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("BlogArticle");

  private static final TField USER_ID_FIELD_DESC = new TField("userId", TType.STRING, (short)1);
  private static final TField ARTICLE_ID_FIELD_DESC = new TField("articleId", TType.I64, (short)2);
  private static final TField TITLE_FIELD_DESC = new TField("title", TType.STRING, (short)3);
  private static final TField CONTENTS_FIELD_DESC = new TField("contents", TType.STRING, (short)4);

  public String userId;
  public long articleId;
  public String title;
  public ByteBuffer contents;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    USER_ID((short)1, "userId"),
    ARTICLE_ID((short)2, "articleId"),
    TITLE((short)3, "title"),
    CONTENTS((short)4, "contents");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_ID
          return USER_ID;
        case 2: // ARTICLE_ID
          return ARTICLE_ID;
        case 3: // TITLE
          return TITLE;
        case 4: // CONTENTS
          return CONTENTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ARTICLEID_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new FieldMetaData("userId", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.ARTICLE_ID, new FieldMetaData("articleId", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.TITLE, new FieldMetaData("title", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.CONTENTS, new FieldMetaData("contents", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(BlogArticle.class, metaDataMap);
  }

  public BlogArticle() {
  }

  public BlogArticle(
    String userId,
    long articleId,
    String title,
    ByteBuffer contents)
  {
    this();
    this.userId = userId;
    this.articleId = articleId;
    setArticleIdIsSet(true);
    this.title = title;
    this.contents = contents;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BlogArticle(BlogArticle other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetUserId()) {
      this.userId = other.userId;
    }
    this.articleId = other.articleId;
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetContents()) {
      this.contents = TBaseHelper.copyBinary(other.contents);
;
    }
  }

  public BlogArticle deepCopy() {
    return new BlogArticle(this);
  }

  @Override
  public void clear() {
    this.userId = null;
    setArticleIdIsSet(false);
    this.articleId = 0;
    this.title = null;
    this.contents = null;
  }

  public String getUserId() {
    return this.userId;
  }

  public BlogArticle setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public void unsetUserId() {
    this.userId = null;
  }

  /** Returns true if field userId is set (has been asigned a value) and false otherwise */
  public boolean isSetUserId() {
    return this.userId != null;
  }

  public void setUserIdIsSet(boolean value) {
    if (!value) {
      this.userId = null;
    }
  }

  public long getArticleId() {
    return this.articleId;
  }

  public BlogArticle setArticleId(long articleId) {
    this.articleId = articleId;
    setArticleIdIsSet(true);
    return this;
  }

  public void unsetArticleId() {
    __isset_bit_vector.clear(__ARTICLEID_ISSET_ID);
  }

  /** Returns true if field articleId is set (has been asigned a value) and false otherwise */
  public boolean isSetArticleId() {
    return __isset_bit_vector.get(__ARTICLEID_ISSET_ID);
  }

  public void setArticleIdIsSet(boolean value) {
    __isset_bit_vector.set(__ARTICLEID_ISSET_ID, value);
  }

  public String getTitle() {
    return this.title;
  }

  public BlogArticle setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been asigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public byte[] getContents() {
    setContents(TBaseHelper.rightSize(contents));
    return contents.array();
  }

  public ByteBuffer BufferForContents() {
    return contents;
  }

  public BlogArticle setContents(byte[] contents) {
    setContents(ByteBuffer.wrap(contents));
    return this;
  }

  public BlogArticle setContents(ByteBuffer contents) {
    this.contents = contents;
    return this;
  }

  public void unsetContents() {
    this.contents = null;
  }

  /** Returns true if field contents is set (has been asigned a value) and false otherwise */
  public boolean isSetContents() {
    return this.contents != null;
  }

  public void setContentsIsSet(boolean value) {
    if (!value) {
      this.contents = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((String)value);
      }
      break;

    case ARTICLE_ID:
      if (value == null) {
        unsetArticleId();
      } else {
        setArticleId((Long)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case CONTENTS:
      if (value == null) {
        unsetContents();
      } else {
        setContents((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return getUserId();

    case ARTICLE_ID:
      return new Long(getArticleId());

    case TITLE:
      return getTitle();

    case CONTENTS:
      return getContents();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case ARTICLE_ID:
      return isSetArticleId();
    case TITLE:
      return isSetTitle();
    case CONTENTS:
      return isSetContents();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BlogArticle)
      return this.equals((BlogArticle)that);
    return false;
  }

  public boolean equals(BlogArticle that) {
    if (that == null)
      return false;

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (!this.userId.equals(that.userId))
        return false;
    }

    boolean this_present_articleId = true;
    boolean that_present_articleId = true;
    if (this_present_articleId || that_present_articleId) {
      if (!(this_present_articleId && that_present_articleId))
        return false;
      if (this.articleId != that.articleId)
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_contents = true && this.isSetContents();
    boolean that_present_contents = true && that.isSetContents();
    if (this_present_contents || that_present_contents) {
      if (!(this_present_contents && that_present_contents))
        return false;
      if (!this.contents.equals(that.contents))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(BlogArticle other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    BlogArticle typedOther = (BlogArticle)other;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(typedOther.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = TBaseHelper.compareTo(this.userId, typedOther.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArticleId()).compareTo(typedOther.isSetArticleId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArticleId()) {
      lastComparison = TBaseHelper.compareTo(this.articleId, typedOther.articleId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(typedOther.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = TBaseHelper.compareTo(this.title, typedOther.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetContents()).compareTo(typedOther.isSetContents());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContents()) {
      lastComparison = TBaseHelper.compareTo(this.contents, typedOther.contents);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // USER_ID
          if (field.type == TType.STRING) {
            this.userId = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // ARTICLE_ID
          if (field.type == TType.I64) {
            this.articleId = iprot.readI64();
            setArticleIdIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // TITLE
          if (field.type == TType.STRING) {
            this.title = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // CONTENTS
          if (field.type == TType.STRING) {
            this.contents = iprot.readBinary();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.userId != null) {
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeString(this.userId);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(ARTICLE_ID_FIELD_DESC);
    oprot.writeI64(this.articleId);
    oprot.writeFieldEnd();
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    if (this.contents != null) {
      oprot.writeFieldBegin(CONTENTS_FIELD_DESC);
      oprot.writeBinary(this.contents);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BlogArticle(");
    boolean first = true;

    sb.append("userId:");
    if (this.userId == null) {
      sb.append("null");
    } else {
      sb.append(this.userId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("articleId:");
    sb.append(this.articleId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("contents:");
    if (this.contents == null) {
      sb.append("null");
    } else {
      TBaseHelper.toString(this.contents, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

