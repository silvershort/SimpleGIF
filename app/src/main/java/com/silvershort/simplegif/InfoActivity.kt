package com.silvershort.simplegif

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.silvershort.simplegif.R
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        setSupportActionBar(info_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        info_license1_btn.setOnClickListener {
            showDialog("https://github.com/google/ExoPlayer\n\n   Apache License\n" +
                    "                           Version 2.0, January 2004\n" +
                    "                        http://www.apache.org/licenses/\n" +
                    "\n" +
                    "   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION\n" +
                    "\n" +
                    "   1. Definitions.\n" +
                    "\n" +
                    "      \"License\" shall mean the terms and conditions for use, reproduction,\n" +
                    "      and distribution as defined by Sections 1 through 9 of this document.\n" +
                    "\n" +
                    "      \"Licensor\" shall mean the copyright owner or entity authorized by\n" +
                    "      the copyright owner that is granting the License.\n" +
                    "\n" +
                    "      \"Legal Entity\" shall mean the union of the acting entity and all\n" +
                    "      other entities that control, are controlled by, or are under common\n" +
                    "      control with that entity. For the purposes of this definition,\n" +
                    "      \"control\" means (i) the power, direct or indirect, to cause the\n" +
                    "      direction or management of such entity, whether by contract or\n" +
                    "      otherwise, or (ii) ownership of fifty percent (50%) or more of the\n" +
                    "      outstanding shares, or (iii) beneficial ownership of such entity.\n" +
                    "\n" +
                    "      \"You\" (or \"Your\") shall mean an individual or Legal Entity\n" +
                    "      exercising permissions granted by this License.\n" +
                    "\n" +
                    "      \"Source\" form shall mean the preferred form for making modifications,\n" +
                    "      including but not limited to software source code, documentation\n" +
                    "      source, and configuration files.\n" +
                    "\n" +
                    "      \"Object\" form shall mean any form resulting from mechanical\n" +
                    "      transformation or translation of a Source form, including but\n" +
                    "      not limited to compiled object code, generated documentation,\n" +
                    "      and conversions to other media types.\n" +
                    "\n" +
                    "      \"Work\" shall mean the work of authorship, whether in Source or\n" +
                    "      Object form, made available under the License, as indicated by a\n" +
                    "      copyright notice that is included in or attached to the work\n" +
                    "      (an example is provided in the Appendix below).\n" +
                    "\n" +
                    "      \"Derivative Works\" shall mean any work, whether in Source or Object\n" +
                    "      form, that is based on (or derived from) the Work and for which the\n" +
                    "      editorial revisions, annotations, elaborations, or other modifications\n" +
                    "      represent, as a whole, an original work of authorship. For the purposes\n" +
                    "      of this License, Derivative Works shall not include works that remain\n" +
                    "      separable from, or merely link (or bind by name) to the interfaces of,\n" +
                    "      the Work and Derivative Works thereof.\n" +
                    "\n" +
                    "      \"Contribution\" shall mean any work of authorship, including\n" +
                    "      the original version of the Work and any modifications or additions\n" +
                    "      to that Work or Derivative Works thereof, that is intentionally\n" +
                    "      submitted to Licensor for inclusion in the Work by the copyright owner\n" +
                    "      or by an individual or Legal Entity authorized to submit on behalf of\n" +
                    "      the copyright owner. For the purposes of this definition, \"submitted\"\n" +
                    "      means any form of electronic, verbal, or written communication sent\n" +
                    "      to the Licensor or its representatives, including but not limited to\n" +
                    "      communication on electronic mailing lists, source code control systems,\n" +
                    "      and issue tracking systems that are managed by, or on behalf of, the\n" +
                    "      Licensor for the purpose of discussing and improving the Work, but\n" +
                    "      excluding communication that is conspicuously marked or otherwise\n" +
                    "      designated in writing by the copyright owner as \"Not a Contribution.\"\n" +
                    "\n" +
                    "      \"Contributor\" shall mean Licensor and any individual or Legal Entity\n" +
                    "      on behalf of whom a Contribution has been received by Licensor and\n" +
                    "      subsequently incorporated within the Work.\n" +
                    "\n" +
                    "   2. Grant of Copyright License. Subject to the terms and conditions of\n" +
                    "      this License, each Contributor hereby grants to You a perpetual,\n" +
                    "      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n" +
                    "      copyright license to reproduce, prepare Derivative Works of,\n" +
                    "      publicly display, publicly perform, sublicense, and distribute the\n" +
                    "      Work and such Derivative Works in Source or Object form.\n" +
                    "\n" +
                    "   3. Grant of Patent License. Subject to the terms and conditions of\n" +
                    "      this License, each Contributor hereby grants to You a perpetual,\n" +
                    "      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n" +
                    "      (except as stated in this section) patent license to make, have made,\n" +
                    "      use, offer to sell, sell, import, and otherwise transfer the Work,\n" +
                    "      where such license applies only to those patent claims licensable\n" +
                    "      by such Contributor that are necessarily infringed by their\n" +
                    "      Contribution(s) alone or by combination of their Contribution(s)\n" +
                    "      with the Work to which such Contribution(s) was submitted. If You\n" +
                    "      institute patent litigation against any entity (including a\n" +
                    "      cross-claim or counterclaim in a lawsuit) alleging that the Work\n" +
                    "      or a Contribution incorporated within the Work constitutes direct\n" +
                    "      or contributory patent infringement, then any patent licenses\n" +
                    "      granted to You under this License for that Work shall terminate\n" +
                    "      as of the date such litigation is filed.\n" +
                    "\n" +
                    "   4. Redistribution. You may reproduce and distribute copies of the\n" +
                    "      Work or Derivative Works thereof in any medium, with or without\n" +
                    "      modifications, and in Source or Object form, provided that You\n" +
                    "      meet the following conditions:\n" +
                    "\n" +
                    "      (a) You must give any other recipients of the Work or\n" +
                    "          Derivative Works a copy of this License; and\n" +
                    "\n" +
                    "      (b) You must cause any modified files to carry prominent notices\n" +
                    "          stating that You changed the files; and\n" +
                    "\n" +
                    "      (c) You must retain, in the Source form of any Derivative Works\n" +
                    "          that You distribute, all copyright, patent, trademark, and\n" +
                    "          attribution notices from the Source form of the Work,\n" +
                    "          excluding those notices that do not pertain to any part of\n" +
                    "          the Derivative Works; and\n" +
                    "\n" +
                    "      (d) If the Work includes a \"NOTICE\" text file as part of its\n" +
                    "          distribution, then any Derivative Works that You distribute must\n" +
                    "          include a readable copy of the attribution notices contained\n" +
                    "          within such NOTICE file, excluding those notices that do not\n" +
                    "          pertain to any part of the Derivative Works, in at least one\n" +
                    "          of the following places: within a NOTICE text file distributed\n" +
                    "          as part of the Derivative Works; within the Source form or\n" +
                    "          documentation, if provided along with the Derivative Works; or,\n" +
                    "          within a display generated by the Derivative Works, if and\n" +
                    "          wherever such third-party notices normally appear. The contents\n" +
                    "          of the NOTICE file are for informational purposes only and\n" +
                    "          do not modify the License. You may add Your own attribution\n" +
                    "          notices within Derivative Works that You distribute, alongside\n" +
                    "          or as an addendum to the NOTICE text from the Work, provided\n" +
                    "          that such additional attribution notices cannot be construed\n" +
                    "          as modifying the License.\n" +
                    "\n" +
                    "      You may add Your own copyright statement to Your modifications and\n" +
                    "      may provide additional or different license terms and conditions\n" +
                    "      for use, reproduction, or distribution of Your modifications, or\n" +
                    "      for any such Derivative Works as a whole, provided Your use,\n" +
                    "      reproduction, and distribution of the Work otherwise complies with\n" +
                    "      the conditions stated in this License.\n" +
                    "\n" +
                    "   5. Submission of Contributions. Unless You explicitly state otherwise,\n" +
                    "      any Contribution intentionally submitted for inclusion in the Work\n" +
                    "      by You to the Licensor shall be under the terms and conditions of\n" +
                    "      this License, without any additional terms or conditions.\n" +
                    "      Notwithstanding the above, nothing herein shall supersede or modify\n" +
                    "      the terms of any separate license agreement you may have executed\n" +
                    "      with Licensor regarding such Contributions.\n" +
                    "\n" +
                    "   6. Trademarks. This License does not grant permission to use the trade\n" +
                    "      names, trademarks, service marks, or product names of the Licensor,\n" +
                    "      except as required for reasonable and customary use in describing the\n" +
                    "      origin of the Work and reproducing the content of the NOTICE file.\n" +
                    "\n" +
                    "   7. Disclaimer of Warranty. Unless required by applicable law or\n" +
                    "      agreed to in writing, Licensor provides the Work (and each\n" +
                    "      Contributor provides its Contributions) on an \"AS IS\" BASIS,\n" +
                    "      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or\n" +
                    "      implied, including, without limitation, any warranties or conditions\n" +
                    "      of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A\n" +
                    "      PARTICULAR PURPOSE. You are solely responsible for determining the\n" +
                    "      appropriateness of using or redistributing the Work and assume any\n" +
                    "      risks associated with Your exercise of permissions under this License.\n" +
                    "\n" +
                    "   8. Limitation of Liability. In no event and under no legal theory,\n" +
                    "      whether in tort (including negligence), contract, or otherwise,\n" +
                    "      unless required by applicable law (such as deliberate and grossly\n" +
                    "      negligent acts) or agreed to in writing, shall any Contributor be\n" +
                    "      liable to You for damages, including any direct, indirect, special,\n" +
                    "      incidental, or consequential damages of any character arising as a\n" +
                    "      result of this License or out of the use or inability to use the\n" +
                    "      Work (including but not limited to damages for loss of goodwill,\n" +
                    "      work stoppage, computer failure or malfunction, or any and all\n" +
                    "      other commercial damages or losses), even if such Contributor\n" +
                    "      has been advised of the possibility of such damages.\n" +
                    "\n" +
                    "   9. Accepting Warranty or Additional Liability. While redistributing\n" +
                    "      the Work or Derivative Works thereof, You may choose to offer,\n" +
                    "      and charge a fee for, acceptance of support, warranty, indemnity,\n" +
                    "      or other liability obligations and/or rights consistent with this\n" +
                    "      License. However, in accepting such obligations, You may act only\n" +
                    "      on Your own behalf and on Your sole responsibility, not on behalf\n" +
                    "      of any other Contributor, and only if You agree to indemnify,\n" +
                    "      defend, and hold each Contributor harmless for any liability\n" +
                    "      incurred by, or claims asserted against, such Contributor by reason\n" +
                    "      of your accepting any such warranty or additional liability.\n" +
                    "\n" +
                    "   END OF TERMS AND CONDITIONS\n" +
                    "\n" +
                    "   APPENDIX: How to apply the Apache License to your work.\n" +
                    "\n" +
                    "      To apply the Apache License to your work, attach the following\n" +
                    "      boilerplate notice, with the fields enclosed by brackets \"[]\"\n" +
                    "      replaced with your own identifying information. (Don't include\n" +
                    "      the brackets!)  The text should be enclosed in the appropriate\n" +
                    "      comment syntax for the file format. We also recommend that a\n" +
                    "      file or class name and description of purpose be included on the\n" +
                    "      same \"printed page\" as the copyright notice for easier\n" +
                    "      identification within third-party archives.\n" +
                    "\n" +
                    "   Copyright [yyyy] [name of copyright owner]\n" +
                    "\n" +
                    "   Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                    "   you may not use this file except in compliance with the License.\n" +
                    "   You may obtain a copy of the License at\n" +
                    "\n" +
                    "       http://www.apache.org/licenses/LICENSE-2.0\n" +
                    "\n" +
                    "   Unless required by applicable law or agreed to in writing, software\n" +
                    "   distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                    "   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                    "   See the License for the specific language governing permissions and\n" +
                    "   limitations under the License.")
        }
        info_license2_btn.setOnClickListener {
            showDialog("https://github.com/bumptech/glide\n\nLicense for everything not in third_party and not otherwise marked:\n" +
                    "\n" +
                    "Copyright 2014 Google, Inc. All rights reserved.\n" +
                    "\n" +
                    "Redistribution and use in source and binary forms, with or without modification, are\n" +
                    "permitted provided that the following conditions are met:\n" +
                    "\n" +
                    "   1. Redistributions of source code must retain the above copyright notice, this list of\n" +
                    "         conditions and the following disclaimer.\n" +
                    "\n" +
                    "   2. Redistributions in binary form must reproduce the above copyright notice, this list\n" +
                    "         of conditions and the following disclaimer in the documentation and/or other materials\n" +
                    "         provided with the distribution.\n" +
                    "\n" +
                    "THIS SOFTWARE IS PROVIDED BY GOOGLE, INC. ``AS IS'' AND ANY EXPRESS OR IMPLIED\n" +
                    "WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n" +
                    "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GOOGLE, INC. OR\n" +
                    "CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR\n" +
                    "CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR\n" +
                    "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON\n" +
                    "ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING\n" +
                    "NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF\n" +
                    "ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n" +
                    "\n" +
                    "The views and conclusions contained in the software and documentation are those of the\n" +
                    "authors and should not be interpreted as representing official policies, either expressed\n" +
                    "or implied, of Google, Inc.\n" +
                    "---------------------------------------------------------------------------------------------\n" +
                    "License for third_party/disklrucache:\n" +
                    "\n" +
                    "Copyright 2012 Jake Wharton\n" +
                    "Copyright 2011 The Android Open Source Project\n" +
                    "\n" +
                    "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                    "you may not use this file except in compliance with the License.\n" +
                    "You may obtain a copy of the License at\n" +
                    "\n" +
                    "   http://www.apache.org/licenses/LICENSE-2.0\n" +
                    "\n" +
                    "Unless required by applicable law or agreed to in writing, software\n" +
                    "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                    "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                    "See the License for the specific language governing permissions and\n" +
                    "limitations under the License.\n" +
                    "---------------------------------------------------------------------------------------------\n" +
                    "License for third_party/gif_decoder:\n" +
                    "\n" +
                    "Copyright (c) 2013 Xcellent Creations, Inc.\n" +
                    "\n" +
                    "Permission is hereby granted, free of charge, to any person obtaining\n" +
                    "a copy of this software and associated documentation files (the\n" +
                    "\"Software\"), to deal in the Software without restriction, including\n" +
                    "without limitation the rights to use, copy, modify, merge, publish,\n" +
                    "distribute, sublicense, and/or sell copies of the Software, and to\n" +
                    "permit persons to whom the Software is furnished to do so, subject to\n" +
                    "the following conditions:\n" +
                    "\n" +
                    "The above copyright notice and this permission notice shall be\n" +
                    "included in all copies or substantial portions of the Software.\n" +
                    "\n" +
                    "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n" +
                    "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n" +
                    "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n" +
                    "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE\n" +
                    "LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION\n" +
                    "OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION\n" +
                    "WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n" +
                    "---------------------------------------------------------------------------------------------\n" +
                    "License for third_party/gif_encoder/AnimatedGifEncoder.java and\n" +
                    "third_party/gif_encoder/LZWEncoder.java:\n" +
                    "\n" +
                    "No copyright asserted on the source code of this class. May be used for any\n" +
                    "purpose, however, refer to the Unisys LZW patent for restrictions on use of\n" +
                    "the associated LZWEncoder class. Please forward any corrections to\n" +
                    "kweiner@fmsware.com.\n" +
                    "\n" +
                    "-----------------------------------------------------------------------------\n" +
                    "License for third_party/gif_encoder/NeuQuant.java\n" +
                    "\n" +
                    "Copyright (c) 1994 Anthony Dekker\n" +
                    "\n" +
                    "NEUQUANT Neural-Net quantization algorithm by Anthony Dekker, 1994. See\n" +
                    "\"Kohonen neural networks for optimal colour quantization\" in \"Network:\n" +
                    "Computation in Neural Systems\" Vol. 5 (1994) pp 351-367. for a discussion of\n" +
                    "the algorithm.\n" +
                    "\n" +
                    "Any party obtaining a copy of these files from the author, directly or\n" +
                    "indirectly, is granted, free of charge, a full and unrestricted irrevocable,\n" +
                    "world-wide, paid up, royalty-free, nonexclusive right and license to deal in\n" +
                    "this software and documentation files (the \"Software\"), including without\n" +
                    "limitation the rights to use, copy, modify, merge, publish, distribute,\n" +
                    "sublicense, and/or sell copies of the Software, and to permit persons who\n" +
                    "receive copies from any such party to do so, with the only requirement being\n" +
                    "that this copyright notice remain intact.")
        }
        info_license3_btn.setOnClickListener {
            showDialog("https://github.com/tanersener/mobile-ffmpeg\n\n                    GNU GENERAL PUBLIC LICENSE\n" +
                    "                       Version 3, 29 June 2007\n" +
                    "\n" +
                    " Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>\n" +
                    " Everyone is permitted to copy and distribute verbatim copies\n" +
                    " of this license document, but changing it is not allowed.\n" +
                    "\n" +
                    "                            Preamble\n" +
                    "\n" +
                    "  The GNU General Public License is a free, copyleft license for\n" +
                    "software and other kinds of works.\n" +
                    "\n" +
                    "  The licenses for most software and other practical works are designed\n" +
                    "to take away your freedom to share and change the works.  By contrast,\n" +
                    "the GNU General Public License is intended to guarantee your freedom to\n" +
                    "share and change all versions of a program--to make sure it remains free\n" +
                    "software for all its users.  We, the Free Software Foundation, use the\n" +
                    "GNU General Public License for most of our software; it applies also to\n" +
                    "any other work released this way by its authors.  You can apply it to\n" +
                    "your programs, too.\n" +
                    "\n" +
                    "  When we speak of free software, we are referring to freedom, not\n" +
                    "price.  Our General Public Licenses are designed to make sure that you\n" +
                    "have the freedom to distribute copies of free software (and charge for\n" +
                    "them if you wish), that you receive source code or can get it if you\n" +
                    "want it, that you can change the software or use pieces of it in new\n" +
                    "free programs, and that you know you can do these things.\n" +
                    "\n" +
                    "  To protect your rights, we need to prevent others from denying you\n" +
                    "these rights or asking you to surrender the rights.  Therefore, you have\n" +
                    "certain responsibilities if you distribute copies of the software, or if\n" +
                    "you modify it: responsibilities to respect the freedom of others.\n" +
                    "\n" +
                    "  For example, if you distribute copies of such a program, whether\n" +
                    "gratis or for a fee, you must pass on to the recipients the same\n" +
                    "freedoms that you received.  You must make sure that they, too, receive\n" +
                    "or can get the source code.  And you must show them these terms so they\n" +
                    "know their rights.\n" +
                    "\n" +
                    "  Developers that use the GNU GPL protect your rights with two steps:\n" +
                    "(1) assert copyright on the software, and (2) offer you this License\n" +
                    "giving you legal permission to copy, distribute and/or modify it.\n" +
                    "\n" +
                    "  For the developers' and authors' protection, the GPL clearly explains\n" +
                    "that there is no warranty for this free software.  For both users' and\n" +
                    "authors' sake, the GPL requires that modified versions be marked as\n" +
                    "changed, so that their problems will not be attributed erroneously to\n" +
                    "authors of previous versions.\n" +
                    "\n" +
                    "  Some devices are designed to deny users access to install or run\n" +
                    "modified versions of the software inside them, although the manufacturer\n" +
                    "can do so.  This is fundamentally incompatible with the aim of\n" +
                    "protecting users' freedom to change the software.  The systematic\n" +
                    "pattern of such abuse occurs in the area of products for individuals to\n" +
                    "use, which is precisely where it is most unacceptable.  Therefore, we\n" +
                    "have designed this version of the GPL to prohibit the practice for those\n" +
                    "products.  If such problems arise substantially in other domains, we\n" +
                    "stand ready to extend this provision to those domains in future versions\n" +
                    "of the GPL, as needed to protect the freedom of users.\n" +
                    "\n" +
                    "  Finally, every program is threatened constantly by software patents.\n" +
                    "States should not allow patents to restrict development and use of\n" +
                    "software on general-purpose computers, but in those that do, we wish to\n" +
                    "avoid the special danger that patents applied to a free program could\n" +
                    "make it effectively proprietary.  To prevent this, the GPL assures that\n" +
                    "patents cannot be used to render the program non-free.\n" +
                    "\n" +
                    "  The precise terms and conditions for copying, distribution and\n" +
                    "modification follow.\n" +
                    "\n" +
                    "                       TERMS AND CONDITIONS\n" +
                    "\n" +
                    "  0. Definitions.\n" +
                    "\n" +
                    "  \"This License\" refers to version 3 of the GNU General Public License.\n" +
                    "\n" +
                    "  \"Copyright\" also means copyright-like laws that apply to other kinds of\n" +
                    "works, such as semiconductor masks.\n" +
                    "\n" +
                    "  \"The Program\" refers to any copyrightable work licensed under this\n" +
                    "License.  Each licensee is addressed as \"you\".  \"Licensees\" and\n" +
                    "\"recipients\" may be individuals or organizations.\n" +
                    "\n" +
                    "  To \"modify\" a work means to copy from or adapt all or part of the work\n" +
                    "in a fashion requiring copyright permission, other than the making of an\n" +
                    "exact copy.  The resulting work is called a \"modified version\" of the\n" +
                    "earlier work or a work \"based on\" the earlier work.\n" +
                    "\n" +
                    "  A \"covered work\" means either the unmodified Program or a work based\n" +
                    "on the Program.\n" +
                    "\n" +
                    "  To \"propagate\" a work means to do anything with it that, without\n" +
                    "permission, would make you directly or secondarily liable for\n" +
                    "infringement under applicable copyright law, except executing it on a\n" +
                    "computer or modifying a private copy.  Propagation includes copying,\n" +
                    "distribution (with or without modification), making available to the\n" +
                    "public, and in some countries other activities as well.\n" +
                    "\n" +
                    "  To \"convey\" a work means any kind of propagation that enables other\n" +
                    "parties to make or receive copies.  Mere interaction with a user through\n" +
                    "a computer network, with no transfer of a copy, is not conveying.\n" +
                    "\n" +
                    "  An interactive user interface displays \"Appropriate Legal Notices\"\n" +
                    "to the extent that it includes a convenient and prominently visible\n" +
                    "feature that (1) displays an appropriate copyright notice, and (2)\n" +
                    "tells the user that there is no warranty for the work (except to the\n" +
                    "extent that warranties are provided), that licensees may convey the\n" +
                    "work under this License, and how to view a copy of this License.  If\n" +
                    "the interface presents a list of user commands or options, such as a\n" +
                    "menu, a prominent item in the list meets this criterion.\n")
        }
        info_license4_btn.setOnClickListener {
            showDialog("https://github.com/WhiteDG/ProgressView\n\n                                 Apache License\n" +
                    "                           Version 2.0, January 2004\n" +
                    "                        http://www.apache.org/licenses/\n" +
                    "\n" +
                    "   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION\n" +
                    "\n" +
                    "   1. Definitions.\n" +
                    "\n" +
                    "      \"License\" shall mean the terms and conditions for use, reproduction,\n" +
                    "      and distribution as defined by Sections 1 through 9 of this document.\n" +
                    "\n" +
                    "      \"Licensor\" shall mean the copyright owner or entity authorized by\n" +
                    "      the copyright owner that is granting the License.\n" +
                    "\n" +
                    "      \"Legal Entity\" shall mean the union of the acting entity and all\n" +
                    "      other entities that control, are controlled by, or are under common\n" +
                    "      control with that entity. For the purposes of this definition,\n" +
                    "      \"control\" means (i) the power, direct or indirect, to cause the\n" +
                    "      direction or management of such entity, whether by contract or\n" +
                    "      otherwise, or (ii) ownership of fifty percent (50%) or more of the\n" +
                    "      outstanding shares, or (iii) beneficial ownership of such entity.\n" +
                    "\n" +
                    "      \"You\" (or \"Your\") shall mean an individual or Legal Entity\n" +
                    "      exercising permissions granted by this License.\n" +
                    "\n" +
                    "      \"Source\" form shall mean the preferred form for making modifications,\n" +
                    "      including but not limited to software source code, documentation\n" +
                    "      source, and configuration files.\n" +
                    "\n" +
                    "      \"Object\" form shall mean any form resulting from mechanical\n" +
                    "      transformation or translation of a Source form, including but\n" +
                    "      not limited to compiled object code, generated documentation,\n" +
                    "      and conversions to other media types.\n" +
                    "\n" +
                    "      \"Work\" shall mean the work of authorship, whether in Source or\n" +
                    "      Object form, made available under the License, as indicated by a\n" +
                    "      copyright notice that is included in or attached to the work\n" +
                    "      (an example is provided in the Appendix below).\n" +
                    "\n" +
                    "      \"Derivative Works\" shall mean any work, whether in Source or Object\n" +
                    "      form, that is based on (or derived from) the Work and for which the\n" +
                    "      editorial revisions, annotations, elaborations, or other modifications\n" +
                    "      represent, as a whole, an original work of authorship. For the purposes\n" +
                    "      of this License, Derivative Works shall not include works that remain\n" +
                    "      separable from, or merely link (or bind by name) to the interfaces of,\n" +
                    "      the Work and Derivative Works thereof.\n" +
                    "\n" +
                    "      \"Contribution\" shall mean any work of authorship, including\n" +
                    "      the original version of the Work and any modifications or additions\n" +
                    "      to that Work or Derivative Works thereof, that is intentionally\n" +
                    "      submitted to Licensor for inclusion in the Work by the copyright owner\n" +
                    "      or by an individual or Legal Entity authorized to submit on behalf of\n" +
                    "      the copyright owner. For the purposes of this definition, \"submitted\"\n" +
                    "      means any form of electronic, verbal, or written communication sent\n" +
                    "      to the Licensor or its representatives, including but not limited to\n" +
                    "      communication on electronic mailing lists, source code control systems,\n" +
                    "      and issue tracking systems that are managed by, or on behalf of, the\n" +
                    "      Licensor for the purpose of discussing and improving the Work, but\n" +
                    "      excluding communication that is conspicuously marked or otherwise\n" +
                    "      designated in writing by the copyright owner as \"Not a Contribution.\"\n" +
                    "\n" +
                    "      \"Contributor\" shall mean Licensor and any individual or Legal Entity\n" +
                    "      on behalf of whom a Contribution has been received by Licensor and\n" +
                    "      subsequently incorporated within the Work.\n" +
                    "\n" +
                    "   2. Grant of Copyright License. Subject to the terms and conditions of\n" +
                    "      this License, each Contributor hereby grants to You a perpetual,\n" +
                    "      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n" +
                    "      copyright license to reproduce, prepare Derivative Works of,\n" +
                    "      publicly display, publicly perform, sublicense, and distribute the\n" +
                    "      Work and such Derivative Works in Source or Object form.\n" +
                    "\n" +
                    "   3. Grant of Patent License. Subject to the terms and conditions of\n" +
                    "      this License, each Contributor hereby grants to You a perpetual,\n" +
                    "      worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n" +
                    "      (except as stated in this section) patent license to make, have made,\n" +
                    "      use, offer to sell, sell, import, and otherwise transfer the Work,\n" +
                    "      where such license applies only to those patent claims licensable\n" +
                    "      by such Contributor that are necessarily infringed by their\n" +
                    "      Contribution(s) alone or by combination of their Contribution(s)\n" +
                    "      with the Work to which such Contribution(s) was submitted. If You\n" +
                    "      institute patent litigation against any entity (including a\n" +
                    "      cross-claim or counterclaim in a lawsuit) alleging that the Work\n" +
                    "      or a Contribution incorporated within the Work constitutes direct\n" +
                    "      or contributory patent infringement, then any patent licenses\n" +
                    "      granted to You under this License for that Work shall terminate\n" +
                    "      as of the date such litigation is filed.\n" +
                    "\n" +
                    "   4. Redistribution. You may reproduce and distribute copies of the\n" +
                    "      Work or Derivative Works thereof in any medium, with or without\n" +
                    "      modifications, and in Source or Object form, provided that You\n" +
                    "      meet the following conditions:\n" +
                    "\n" +
                    "      (a) You must give any other recipients of the Work or\n" +
                    "          Derivative Works a copy of this License; and\n" +
                    "\n" +
                    "      (b) You must cause any modified files to carry prominent notices\n" +
                    "          stating that You changed the files; and\n" +
                    "\n" +
                    "      (c) You must retain, in the Source form of any Derivative Works\n" +
                    "          that You distribute, all copyright, patent, trademark, and\n" +
                    "          attribution notices from the Source form of the Work,\n" +
                    "          excluding those notices that do not pertain to any part of\n" +
                    "          the Derivative Works; and\n" +
                    "\n" +
                    "      (d) If the Work includes a \"NOTICE\" text file as part of its\n" +
                    "          distribution, then any Derivative Works that You distribute must\n" +
                    "          include a readable copy of the attribution notices contained\n" +
                    "          within such NOTICE file, excluding those notices that do not\n" +
                    "          pertain to any part of the Derivative Works, in at least one\n" +
                    "          of the following places: within a NOTICE text file distributed\n" +
                    "          as part of the Derivative Works; within the Source form or\n" +
                    "          documentation, if provided along with the Derivative Works; or,\n" +
                    "          within a display generated by the Derivative Works, if and\n" +
                    "          wherever such third-party notices normally appear. The contents\n" +
                    "          of the NOTICE file are for informational purposes only and\n" +
                    "          do not modify the License. You may add Your own attribution\n" +
                    "          notices within Derivative Works that You distribute, alongside\n" +
                    "          or as an addendum to the NOTICE text from the Work, provided\n" +
                    "          that such additional attribution notices cannot be construed\n" +
                    "          as modifying the License.\n" +
                    "\n" +
                    "      You may add Your own copyright statement to Your modifications and\n" +
                    "      may provide additional or different license terms and conditions\n" +
                    "      for use, reproduction, or distribution of Your modifications, or\n" +
                    "      for any such Derivative Works as a whole, provided Your use,\n" +
                    "      reproduction, and distribution of the Work otherwise complies with\n" +
                    "      the conditions stated in this License.\n" +
                    "\n" +
                    "   5. Submission of Contributions. Unless You explicitly state otherwise,\n" +
                    "      any Contribution intentionally submitted for inclusion in the Work\n" +
                    "      by You to the Licensor shall be under the terms and conditions of\n" +
                    "      this License, without any additional terms or conditions.\n" +
                    "      Notwithstanding the above, nothing herein shall supersede or modify\n" +
                    "      the terms of any separate license agreement you may have executed\n" +
                    "      with Licensor regarding such Contributions.\n" +
                    "\n" +
                    "   6. Trademarks. This License does not grant permission to use the trade\n" +
                    "      names, trademarks, service marks, or product names of the Licensor,\n" +
                    "      except as required for reasonable and customary use in describing the\n" +
                    "      origin of the Work and reproducing the content of the NOTICE file.\n" +
                    "\n" +
                    "   7. Disclaimer of Warranty. Unless required by applicable law or\n" +
                    "      agreed to in writing, Licensor provides the Work (and each\n" +
                    "      Contributor provides its Contributions) on an \"AS IS\" BASIS,\n" +
                    "      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or\n" +
                    "      implied, including, without limitation, any warranties or conditions\n" +
                    "      of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A\n" +
                    "      PARTICULAR PURPOSE. You are solely responsible for determining the\n" +
                    "      appropriateness of using or redistributing the Work and assume any\n" +
                    "      risks associated with Your exercise of permissions under this License.\n" +
                    "\n" +
                    "   8. Limitation of Liability. In no event and under no legal theory,\n" +
                    "      whether in tort (including negligence), contract, or otherwise,\n" +
                    "      unless required by applicable law (such as deliberate and grossly\n" +
                    "      negligent acts) or agreed to in writing, shall any Contributor be\n" +
                    "      liable to You for damages, including any direct, indirect, special,\n" +
                    "      incidental, or consequential damages of any character arising as a\n" +
                    "      result of this License or out of the use or inability to use the\n" +
                    "      Work (including but not limited to damages for loss of goodwill,\n" +
                    "      work stoppage, computer failure or malfunction, or any and all\n" +
                    "      other commercial damages or losses), even if such Contributor\n" +
                    "      has been advised of the possibility of such damages.\n" +
                    "\n" +
                    "   9. Accepting Warranty or Additional Liability. While redistributing\n" +
                    "      the Work or Derivative Works thereof, You may choose to offer,\n" +
                    "      and charge a fee for, acceptance of support, warranty, indemnity,\n" +
                    "      or other liability obligations and/or rights consistent with this\n" +
                    "      License. However, in accepting such obligations, You may act only\n" +
                    "      on Your own behalf and on Your sole responsibility, not on behalf\n" +
                    "      of any other Contributor, and only if You agree to indemnify,\n" +
                    "      defend, and hold each Contributor harmless for any liability\n" +
                    "      incurred by, or claims asserted against, such Contributor by reason\n" +
                    "      of your accepting any such warranty or additional liability.\n" +
                    "\n" +
                    "   END OF TERMS AND CONDITIONS\n" +
                    "\n" +
                    "   APPENDIX: How to apply the Apache License to your work.\n" +
                    "\n" +
                    "      To apply the Apache License to your work, attach the following\n" +
                    "      boilerplate notice, with the fields enclosed by brackets \"[]\"\n" +
                    "      replaced with your own identifying information. (Don't include\n" +
                    "      the brackets!)  The text should be enclosed in the appropriate\n" +
                    "      comment syntax for the file format. We also recommend that a\n" +
                    "      file or class name and description of purpose be included on the\n" +
                    "      same \"printed page\" as the copyright notice for easier\n" +
                    "      identification within third-party archives.\n" +
                    "\n" +
                    "   Copyright 2014 The Android Open Source Project\n" +
                    "\n" +
                    "   Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                    "   you may not use this file except in compliance with the License.\n" +
                    "   You may obtain a copy of the License at\n" +
                    "\n" +
                    "       http://www.apache.org/licenses/LICENSE-2.0\n" +
                    "\n" +
                    "   Unless required by applicable law or agreed to in writing, software\n" +
                    "   distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                    "   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                    "   See the License for the specific language governing permissions and\n" +
                    "   limitations under the License.")
        }
    }

    private fun showDialog(msg: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(msg)
            .setPositiveButton(getString(R.string.common_ok)
            ) { dialog, which -> }
        builder.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
