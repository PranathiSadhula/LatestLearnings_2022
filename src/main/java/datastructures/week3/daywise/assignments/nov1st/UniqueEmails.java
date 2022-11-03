package datastructures.week3.daywise.assignments.nov1st;

import org.junit.Test;

import java.util.HashMap;

public class UniqueEmails {
    /**
     *
     * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
     *
     * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
     * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
     *
     * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
     * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
     *
     * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
     * It is possible to use both of these rules at the same time.
     *
     * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
     *
     *
     *
     * Example 1:
     *
     * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * Output: 2
     * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
     * Example 2:
     *
     * Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
     * Output: 3
     *
     *
     * Constraints:
     *
     * 1 <= emails.length <= 100
     * 1 <= emails[i].length <= 100
     * emails[i] consist of lowercase English letters, '+', '.' and '@'.
     * Each emails[i] contains exactly one '@' character.
     * All local and domain names are non-empty.
     * Local names do not start with a '+' character.
     * Domain names end with the ".com" suffix.
     */


    /**
     * - check if emails.length > 1, else return invalid testcase;
     *
     * - initialize a map to hold local and domain as key value pair.
     *
     * - iterate through emails for each email.
     *
     * - check if each email is having only "lowercase english letter, +, . and @", else return invalid testcase
     *
     * - now, split each email based on "@"
     *
     * - keep adding split[0] as key(local) and split[1] as value(domain) into map.
     *
     * - while adding key into map, remove . and remove chars occuring after +
     *
     * - finally return map size.
     */

    public int numUniqueEmails(String[] emails) {
        if(emails.length < 1) throw new RuntimeException("Invalid Testcase");
        HashMap<String, String> map = new HashMap<>();
        int count = 0;
        for(String eachEmail : emails){
          String local =  eachEmail.split("@")[0];
          String domain =  eachEmail.split("@")[1];

        //  if(!local.matches("[a-z\\.\\+].*")) throw new RuntimeException("invalidTest");
          local = local.replaceAll("\\.","");
          //
          if(local.contains("+")) local = local.substring(0, local.indexOf("+"));
        //  System.out.println(map.put(local,domain) +":"+ domain);
        try {
            if (!map.put(local, domain).equals(domain)) count++;
        }catch (NullPointerException e){
            count++;
        }

       }


        return count;
    }


    @Test
    public void test(){

        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }


    @Test
    public void test1(){
        String[] emails = {"ihbumoogi+e@rbsvc.com","n.j.ax.t.xcsoz+k@lo.xap.com","x+x.a.w.c+z.e.u+m.y@fnsx.com","fj.j.j.w+tv+g.ri@dvmqt.y.com","fj.j.j.w+z.o.z.h.h@dvmqt.y.com","dg.nru.bcsyw+d@nkynkj.ckq.com","h.f.q.ns+tshpz@nn.r.com","ihbumoogi+e@rbsvc.com","s+l.dl.sft.vn.q@tqbxjqg.com","zze.ovoqr+ds@cx.kahuobzk.com","n.j.ax.t.xcsoz+y@lo.xap.com","n.j.ax.t.xcsoz+c@lo.xap.com","fj.j.j.w+z.ps.fp@dvmqt.y.com","f.q+ibv.d.usw.s@sanzdu.com","s+h+b+v.c+wv+jl+c@tqbxjqg.com","fj.j.j.w+zr.yim@dvmqt.y.com","x+hwywuxhys@fm.qeqlb.com","o.rs+ik.h.s.d.fv@zpavzp.g.com","n.j.ax.t.xcsoz+m@lo.xap.com","e.pt.o.rn+a.uj.u@mqhs.com","x+p+ad+rg+g+n+b+l@fm.qeqlb.com","e.pt.o.rn+e.j.b+o@mqhs.com","e.pt.o.rn+t.x.u+w@mqhs.com","q+e.el.pbr.gkg@knryg.zpztb.com","h.f.q.ns+z.mq+i+f@nn.r.com","x+ou.x+n.fp+lp.t@fnsx.com","ihbumoogi+c@rbsvc.com","x+wv+pq+gyfq.g@fnsx.com","x+mg.t.qg.toff@fm.qeqlb.com","q+d.gzbzme.v+n@knryg.zpztb.com","q+c.f.g.a.i.h.b+h.o@knryg.zpztb.com","zze.ovoqr+yl@cx.kahuobzk.com","ihbumoogi+p@rbsvc.com","n.j.ax.t.xcsoz+e@lo.xap.com","ihbumoogi+b@rbsvc.com","dg.nru.bcsyw+e@nkynkj.ckq.com","h.f.q.ns+f+pust@nn.r.com","s+un.e.t.u.r.t.v.s@tqbxjqg.com","s+l+nqqg.khwb@tqbxjqg.com","fj.j.j.w+n.ggl.u@dvmqt.y.com","n.j.ax.t.xcsoz+b@lo.xap.com","o.rs+lb.z.z.ff.e@zpavzp.g.com","x+vd+lm.a+ui+z.j@fm.qeqlb.com","e.pt.o.rn+kocq@mqhs.com","q+ugt+zzi.e+em@knryg.zpztb.com","zze.ovoqr+nv@cx.kahuobzk.com","zze.ovoqr+yt@cx.kahuobzk.com","zze.ovoqr+fn@cx.kahuobzk.com","f.q+e.d+j.x+b.p+g+s@sanzdu.com","e.pt.o.rn+d.p.p+w@mqhs.com","q+jtigu.e.h.ro@knryg.zpztb.com","h.f.q.ns+rfu+qv@nn.r.com","x+y.x.ki.h+i.lj+e@fm.qeqlb.com","f.q+k.dl.myo.x+b@sanzdu.com","zze.ovoqr+pq@cx.kahuobzk.com","x+q.g.ln.e+e+f.b.v@fm.qeqlb.com","fj.j.j.w+v.p+jo+u@dvmqt.y.com","q+rhhbhnysj@knryg.zpztb.com","fj.j.j.w+wkzvo@dvmqt.y.com","h.f.q.ns+s.x+w+l+a@nn.r.com","n.j.ax.t.xcsoz+v@lo.xap.com","z.q.qs+ibb.q+b.h@gorofcn.com","z.q.qs+x.mw.o+lw@gorofcn.com","q+aca+cmy+f.q.a@knryg.zpztb.com","n.j.ax.t.xcsoz+r@lo.xap.com","z.q.qs+iafh.x+h@gorofcn.com","x+o.fq.dd.d+h.yk@fnsx.com","dg.nru.bcsyw+u@nkynkj.ckq.com","h.f.q.ns+q.e.q.c+t@nn.r.com","q+n.u.d.jm.jbx.v@knryg.zpztb.com","gb.s.uuxow+ge@dmn.qt.com","o.rs+t.mby.z+gv@zpavzp.g.com","o.rs+al.j.k.v.a+h@zpavzp.g.com","x+v+j.m+q.u+h.k+g+z@fnsx.com","e.pt.o.rn+b.a.h.h@mqhs.com","zze.ovoqr+z.m@cx.kahuobzk.com","o.rs+v+z.z.w.p+hu@zpavzp.g.com","e.pt.o.rn+kahp@mqhs.com","fj.j.j.w+d+j.o.r+p@dvmqt.y.com","o.rs+lmo.c+u.za@zpavzp.g.com","x+d+h.xm.t.y+i+p+s@fm.qeqlb.com","ab.dvi.g+z.etq@fu.p.com","q+lnbfkjawq@knryg.zpztb.com","xwlznirsxh+p@mzdvwed.com","x+l.m.co.d+z.i.i.i@fm.qeqlb.com","s+h.o.xep.j.ud+j@tqbxjqg.com","x+gc.dss.k.d+r.m@fm.qeqlb.com","zze.ovoqr+rr@cx.kahuobzk.com","n.j.ax.t.xcsoz+m@lo.xap.com","s+g.k.z+v.yq.y.z+r@tqbxjqg.com","h.f.q.ns+y.f+r.y.w@nn.r.com","z.q.qs+o.ek+n.q+j@gorofcn.com","n.j.ax.t.xcsoz+q@lo.xap.com","q+b.m.c+p.b.m+o.u.b@knryg.zpztb.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
