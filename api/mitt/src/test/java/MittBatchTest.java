/*
 * Copyright (c) 2019 Dafiti Group
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
import br.com.dafiti.mitt.Mitt;
import br.com.dafiti.mitt.exception.DuplicateEntityException;
import br.com.dafiti.mitt.model.Field;
import br.com.dafiti.mitt.transformation.embedded.Now;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valdiney V GOMES
 */
public class MittBatchTest {

    public static void main(String[] args) throws DuplicateEntityException {
        Mitt mitt = new Mitt("/tmp/mitt/batch.csv");

        List<Field> fields = new ArrayList<>();
        fields.add(new Field("id"));

        //mitt.getConfiguration().addField("custom_primary_key", new Concat(fields));
        mitt.getConfiguration().addField("Package Name", "Package");
        mitt.getConfiguration().addCustomField("etl_load_date", new Now());

        mitt.write(new File("/home/valdiney/Downloads/exportDevices_521_20190723.csv"), ',', '"', '\\', "UTF-16");

        mitt.close();
    }
}
