## jstat 用法
   

  ### option： 参数选项
     -t： 可以在打印的列加上Timestamp列，用于显示系统运行的时间
     -h： 可以在周期性数据数据的时候，可以在指定输出多少行以后输出一次表头
     vmid： Virtual Machine ID（ 进程的 pid）
     interval： 执行每次的间隔时间，单位为毫秒
     count： 用于指定输出多少次记录，缺省则会一直打印
     
     #### option 可以从下面参数中选择
     -class 显示ClassLoad的相关信息；
     -compiler 显示JIT编译的相关信息；
     -gc 显示和gc相关的堆信息；
     -gccapacity 　　 显示各个代的容量以及使用情况；
     -gcmetacapacity 显示metaspace的大小
     -gcnew 显示新生代信息；
     -gcnewcapacity 显示新生代大小和使用情况；
     -gcold 显示老年代和永久代的信息；
     -gcoldcapacity 显示老年代的大小；
     -gcutil　　 显示垃圾收集信息；
     -gccause 显示垃圾回收的相关信息（通-gcutil）,同时显示最后一次或当前正在发生的垃圾回收的诱因；
     -printcompilation 输出JIT编译的方法信息；
     
     
   ### 结果说明
     显示内容说明如下（部分结果是通过其他其他参数显示的，暂不说明）：
              S0C：年轻代中第一个survivor（幸存区）的容量 (字节) 
              S1C：年轻代中第二个survivor（幸存区）的容量 (字节) 
              S0U：年轻代中第一个survivor（幸存区）目前已使用空间 (字节) 
              S1U：年轻代中第二个survivor（幸存区）目前已使用空间 (字节) 
              EC：年轻代中Eden（伊甸园）的容量 (字节) 
              EU：年轻代中Eden（伊甸园）目前已使用空间 (字节) 
              OC：Old代的容量 (字节) 
              OU：Old代目前已使用空间 (字节) 
              PC：Perm(持久代)的容量 (字节) 
              PU：Perm(持久代)目前已使用空间 (字节) 
              YGC：从应用程序启动到采样时年轻代中gc次数 
              YGCT：从应用程序启动到采样时年轻代中gc所用时间(s) 
              FGC：从应用程序启动到采样时old代(全gc)gc次数 
              FGCT：从应用程序启动到采样时old代(全gc)gc所用时间(s) 
              GCT：从应用程序启动到采样时gc用的总时间(s) 
              NGCMN：年轻代(young)中初始化(最小)的大小 (字节) 
              NGCMX：年轻代(young)的最大容量 (字节) 
              NGC：年轻代(young)中当前的容量 (字节) 
              OGCMN：old代中初始化(最小)的大小 (字节) 
              OGCMX：old代的最大容量 (字节) 
              OGC：old代当前新生成的容量 (字节) 
              PGCMN：perm代中初始化(最小)的大小 (字节) 
              PGCMX：perm代的最大容量 (字节)   
              PGC：perm代当前新生成的容量 (字节) 
              S0：年轻代中第一个survivor（幸存区）已使用的占当前容量百分比 
              S1：年轻代中第二个survivor（幸存区）已使用的占当前容量百分比 
              E：年轻代中Eden（伊甸园）已使用的占当前容量百分比 
              O：old代已使用的占当前容量百分比 
              P：perm代已使用的占当前容量百分比 
              S0CMX：年轻代中第一个survivor（幸存区）的最大容量 (字节) 
              S1CMX ：年轻代中第二个survivor（幸存区）的最大容量 (字节) 
              ECMX：年轻代中Eden（伊甸园）的最大容量 (字节) 
              DSS：当前需要survivor（幸存区）的容量 (字节)（Eden区已满） 
              TT： 持有次数限制 
              MTT ： 最大持有次数限制 